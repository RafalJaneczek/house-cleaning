package pl.nevernedingcode.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.nevernedingcode.entity.DictionaryEntry;
import pl.nevernedingcode.mapper.DictionaryMapper;
import pl.nevernedingcode.repository.DictionaryRepository;
import pl.nevernedingcode.response.DictionaryEntryResponse;
import pl.nevernedingcode.service.dictionary.DictionaryService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryManagementService implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;
    private final DictionaryMapper dictionaryMapper;

    @Cacheable("dictionaries")
    @Override
    public ResponseEntity<List<DictionaryEntryResponse>> getAllDictionaries() {
        final List<DictionaryEntry> dictionaryEntryList = dictionaryRepository.findAll();
        final List<DictionaryEntryResponse> dictionaryEntryResponseList = dictionaryMapper.mapToDictionaryEntryResponse(dictionaryEntryList);

        log.info("Get dicionaries");
        return ResponseEntity.ok(dictionaryEntryResponseList);
    }

}
