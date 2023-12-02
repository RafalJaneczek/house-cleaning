package pl.nevernedingcode.response;

import java.time.LocalDateTime;

public record CleaningResponse(
        Long id,
        LocalDateTime cleaningDate,
        UserResponse user,
        String roomName) {
}