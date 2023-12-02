package pl.nevernedingcode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nevernedingcode.request.CleaningRequest;
import pl.nevernedingcode.request.PageRequest;
import pl.nevernedingcode.response.CleaningResponse;
import pl.nevernedingcode.response.PageResponse;
import pl.nevernedingcode.service.cleaning.CleaningService;

@RestController
@RequestMapping("/cleaning")
@RequiredArgsConstructor
public class CleaningController {

    private final CleaningService cleaningService;

    @PostMapping("/save")
    ResponseEntity<?> saveCleaning(@RequestBody CleaningRequest request) {
        return cleaningService.saveCleaning(request);
    }

    @PostMapping("/get-all")
    ResponseEntity<PageResponse<CleaningResponse>> getAllCleanings(@RequestBody PageRequest request) {
        return cleaningService.getAllCleanings(request);
    }

}
