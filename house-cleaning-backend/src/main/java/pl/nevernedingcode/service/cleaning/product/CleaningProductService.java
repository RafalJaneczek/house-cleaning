package pl.nevernedingcode.service.cleaning.product;

import org.springframework.http.ResponseEntity;
import pl.nevernedingcode.request.CLeaningProductPageRequest;
import pl.nevernedingcode.request.CleaningProductRequest;
import pl.nevernedingcode.response.CleaningProductResponse;
import pl.nevernedingcode.response.PageResponse;

public interface CleaningProductService {
    ResponseEntity<?> saveProduct(final CleaningProductRequest cleaningProductRequest);

    ResponseEntity<PageResponse<CleaningProductResponse>> getByProductName(final CLeaningProductPageRequest cLeaningProductPageRequest);
}
