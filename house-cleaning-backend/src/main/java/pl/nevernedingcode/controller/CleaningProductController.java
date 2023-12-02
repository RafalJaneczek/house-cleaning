package pl.nevernedingcode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nevernedingcode.request.CLeaningProductPageRequest;
import pl.nevernedingcode.request.CleaningProductRequest;
import pl.nevernedingcode.response.CleaningProductResponse;
import pl.nevernedingcode.response.PageResponse;
import pl.nevernedingcode.service.cleaning.product.CleaningProductService;


@RestController
@RequestMapping("/cleaning-product")
@RequiredArgsConstructor
public class CleaningProductController {

    private final CleaningProductService cleaningProductService;

    @PostMapping("/save")
    ResponseEntity<?> saveCleaningProduct(@RequestBody CleaningProductRequest request) {
        return cleaningProductService.saveProduct(request);
    }

    @PostMapping("/get-by-product-name")
    ResponseEntity<PageResponse<CleaningProductResponse>> getByProductName(@RequestBody CLeaningProductPageRequest request) {
        return cleaningProductService.getByProductName(request);
    }

}
