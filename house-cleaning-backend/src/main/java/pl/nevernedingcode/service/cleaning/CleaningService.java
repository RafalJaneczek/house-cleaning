package pl.nevernedingcode.service.cleaning;

import org.springframework.http.ResponseEntity;
import pl.nevernedingcode.request.CleaningRequest;
import pl.nevernedingcode.request.PageRequest;
import pl.nevernedingcode.response.CleaningResponse;
import pl.nevernedingcode.response.PageResponse;

public interface CleaningService {
    ResponseEntity<PageResponse<CleaningResponse>> saveCleaning(final CleaningRequest cleaningRequest);

    ResponseEntity<PageResponse<CleaningResponse>> getAllCleanings(final PageRequest pageRequest);
}
