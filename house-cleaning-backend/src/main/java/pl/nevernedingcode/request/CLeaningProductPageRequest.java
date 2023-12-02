package pl.nevernedingcode.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public final class CLeaningProductPageRequest extends PageRequest {
    private String productName;
}
