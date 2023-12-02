package pl.nevernedingcode.service.cleaning.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.nevernedingcode.entity.CleaningProduct;
import pl.nevernedingcode.entity.User;
import pl.nevernedingcode.mapper.CleaningProductMapper;
import pl.nevernedingcode.repository.CleaningProductRepository;
import pl.nevernedingcode.request.CLeaningProductPageRequest;
import pl.nevernedingcode.request.CleaningProductRequest;
import pl.nevernedingcode.response.CleaningProductResponse;
import pl.nevernedingcode.response.PageResponse;
import pl.nevernedingcode.service.user.UserService;

import java.util.Collections;
import java.util.List;

import static pl.nevernedingcode.utils.PageUtils.prepareAndGetPageable;

@Service
@RequiredArgsConstructor
public class CleaningProductManagementService implements CleaningProductService {

    private final CleaningProductRepository cleaningProductRepository;
    private final CleaningProductMapper cleaningProductMapper;
    private final UserService userService;


    @Override
    @Transactional
    public ResponseEntity<?> saveProduct(final CleaningProductRequest cleaningProductRequest) {
        final User user = userService.findUserById(cleaningProductRequest.getUserId());
        final CleaningProduct cleaning = CleaningProduct.builder().user(user).productName(cleaningProductRequest.getProductName()).build();
        cleaningProductRepository.save(cleaning);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PageResponse<CleaningProductResponse>> getByProductName(final CLeaningProductPageRequest cLeaningProductPageRequest) {
        final Pageable pageable = prepareAndGetPageable(cLeaningProductPageRequest);
        final Page<CleaningProduct> cleaningProductPage = cleaningProductRepository.findByProductName(cLeaningProductPageRequest.getProductName(), pageable);
        final List<CleaningProduct> cleaningProducts = cleaningProductRepository.findAll();

        if (cleaningProductPage.hasContent()) {
            final List<CleaningProductResponse> cleaningProductPageResponseList = cleaningProductMapper.mapToCleaningProductResponseList(cleaningProductPage.getContent());
            final List<CleaningProductResponse> cleaningProductResponseList = cleaningProductMapper.mapToCleaningProductResponseList(cleaningProducts);
            return ResponseEntity.ok(PageResponse.<CleaningProductResponse>builder()
                    .content(cleaningProductPageResponseList)
                    .fullContent(cleaningProductResponseList)
                    .totalItems(cleaningProductPage.getTotalElements())
                    .build());
        } else {
            return ResponseEntity.ok(PageResponse.<CleaningProductResponse>builder()
                    .content(Collections.emptyList())
                    .fullContent(Collections.emptyList())
                    .totalItems(0)
                    .build());
        }
    }
}
