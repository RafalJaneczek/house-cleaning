package pl.nevernedingcode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nevernedingcode.response.DictionaryEntryResponse;
import pl.nevernedingcode.service.dictionary.DictionaryService;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping("/get-all")
    ResponseEntity<List<DictionaryEntryResponse>> getAllDictionaries() {
        return dictionaryService.getAllDictionaries();
    }

}
