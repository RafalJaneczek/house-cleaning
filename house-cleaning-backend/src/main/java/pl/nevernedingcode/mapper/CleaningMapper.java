package pl.nevernedingcode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import pl.nevernedingcode.entity.Cleaning;
import pl.nevernedingcode.response.CleaningResponse;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CleaningMapper {

    @Autowired
    protected UserMapper userMapper;


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "cleaningDate", source = "cleaningDate"),
            @Mapping(target = "roomName", source = "roomName"),
            @Mapping(target = "user", expression = "java(userMapper.mapToUserResponse(cleaning.getUser()))")
    })
    public abstract CleaningResponse mapToCleaningResponse(Cleaning cleaning);

    public abstract List<CleaningResponse> mapToCleaningResponseList(List<Cleaning> cleaningList);
}
