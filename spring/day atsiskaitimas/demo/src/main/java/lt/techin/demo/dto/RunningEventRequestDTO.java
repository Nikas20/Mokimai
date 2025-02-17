package lt.techin.demo.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RunningEventRequestDTO(
        @NotNull
        @Size(min = 5, max = 255, message = "Minimum 5 Maximum 255 characters")
        String name,
        @NotNull
        @Future
        LocalDate calendarDate,
        @NotNull
        @Pattern(regexp = "^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")
        String location,
        @Min(1)
        int maxParticipants
) {
}
