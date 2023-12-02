package pl.nevernedingcode.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public final class CleaningRequest extends PageRequest {
    @NotNull
    private Long userId;

    @NotBlank
    private String roomName;
}
