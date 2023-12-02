package pl.nevernedingcode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import pl.nevernedingcode.entity.CleaningProduct;
import pl.nevernedingcode.response.CleaningProductResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CleaningProductMapper {

    @Autowired
    protected UserMapper userMapper;

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "dateOfPurchase", source = "dateOfPurchase"),
            @Mapping(target = "productName", source = "productName"),
            @Mapping(target = "user", expression = "java(userMapper.mapToUserResponse(cleaningProduct.getUser()))")
    })
    public abstract CleaningProductResponse mapToCleaningProductResponse(CleaningProduct cleaningProduct);

    public abstract List<CleaningProductResponse> mapToCleaningProductResponseList(List<CleaningProduct> cleaningList);
}
