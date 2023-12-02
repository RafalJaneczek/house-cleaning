package pl.nevernedingcode.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> content;
    private List<T> fullContent;
    private long totalItems;
}
