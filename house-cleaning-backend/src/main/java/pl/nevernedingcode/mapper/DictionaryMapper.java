package pl.nevernedingcode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.nevernedingcode.entity.DictionaryEntry;
import pl.nevernedingcode.response.DictionaryEntryResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DictionaryMapper {

    @Mapping(target = "id", source = "id", ignore = true)
    List<DictionaryEntryResponse> mapToDictionaryEntryResponse(final List<DictionaryEntry> dictionaryEntry);

}
