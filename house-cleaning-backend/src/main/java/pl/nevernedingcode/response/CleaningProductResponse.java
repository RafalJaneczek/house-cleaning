package pl.nevernedingcode.response;

import java.time.LocalDateTime;

public record CleaningProductResponse(
        Long id,
        LocalDateTime dateOfPurchase,
        String productName,
        UserResponse user) {
}
