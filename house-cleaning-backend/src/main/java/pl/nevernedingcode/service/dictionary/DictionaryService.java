package pl.nevernedingcode.service.dictionary;

import org.springframework.http.ResponseEntity;
import pl.nevernedingcode.response.DictionaryEntryResponse;

import java.util.List;

public interface DictionaryService {
    ResponseEntity<List<DictionaryEntryResponse>> getAllDictionaries();
}
