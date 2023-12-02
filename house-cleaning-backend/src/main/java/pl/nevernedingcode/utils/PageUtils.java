package pl.nevernedingcode.utils;

import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.nevernedingcode.request.PageRequest;

public class PageUtils {
    public static Pageable prepareAndGetPageable(final @NonNull PageRequest pageRequest) {
        return org.springframework.data.domain.PageRequest.of(pageRequest.getPageNumber(),
                pageRequest.getPageSize(), Sort.Direction.DESC, String.valueOf(pageRequest.getSort()));
    }
}
