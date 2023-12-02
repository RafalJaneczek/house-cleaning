package pl.nevernedingcode.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public sealed class PageRequest permits CLeaningProductPageRequest, CleaningProductRequest, CleaningRequest {
    protected int pageNumber;
    protected int pageSize;
    protected String sort;
}
