package pl.nevernedingcode.service.cleaning;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.nevernedingcode.entity.Cleaning;
import pl.nevernedingcode.entity.User;
import pl.nevernedingcode.mapper.CleaningMapper;
import pl.nevernedingcode.repository.CleaningRepository;
import pl.nevernedingcode.request.CleaningRequest;
import pl.nevernedingcode.request.PageRequest;
import pl.nevernedingcode.response.CleaningResponse;
import pl.nevernedingcode.response.PageResponse;
import pl.nevernedingcode.service.user.UserService;

import java.util.Collections;
import java.util.List;

import static pl.nevernedingcode.utils.PageUtils.prepareAndGetPageable;

@Service
@RequiredArgsConstructor
public class CleaningManagementService implements CleaningService {

    private final CleaningRepository cleaningRepository;
    private final CleaningMapper cleaningMapper;
    private final UserService userService;

    @Override
    @Transactional
    public ResponseEntity<PageResponse<CleaningResponse>> saveCleaning(@NonNull final CleaningRequest cleaningRequest) {
        final User user = userService.findUserById(cleaningRequest.getUserId());
        final Cleaning cleaning = Cleaning.builder().user(user).roomName(cleaningRequest.getRoomName()).build();
        cleaningRepository.save(cleaning);
        return getAllCleanings(PageRequest.builder()
                .pageNumber(cleaningRequest.getPageNumber())
                .pageSize(cleaningRequest.getPageSize())
                .sort(cleaningRequest.getSort())
                .build());
    }

    @Override
    public ResponseEntity<PageResponse<CleaningResponse>> getAllCleanings(final @NonNull PageRequest pageRequest) {
        final Pageable pageable = prepareAndGetPageable(pageRequest);
        final Page<Cleaning> cleaningPage = cleaningRepository.findAll(pageable);
        final List<Cleaning> cleanings = cleaningRepository.findAll();

        if (cleaningPage.hasContent()) {
            final List<CleaningResponse> cleaningPageResponseList = cleaningMapper.mapToCleaningResponseList(cleaningPage.getContent());
            final List<CleaningResponse> cleaningResponseList = cleaningMapper.mapToCleaningResponseList(cleanings);
            return ResponseEntity.ok(PageResponse.<CleaningResponse>builder()
                    .content(cleaningPageResponseList)
                    .fullContent(cleaningResponseList)
                    .totalItems(cleaningPage.getTotalElements())
                    .build());
        } else {
            return ResponseEntity.ok(PageResponse.<CleaningResponse>builder()
                    .content(Collections.emptyList())
                    .fullContent(Collections.emptyList())
                    .totalItems(0)
                    .build());
        }

    }


}
