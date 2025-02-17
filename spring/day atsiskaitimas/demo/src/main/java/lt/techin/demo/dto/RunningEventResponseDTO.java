package lt.techin.demo.dto;

import java.time.LocalDate;

public record RunningEventResponseDTO(
        long id,
        String name,
        LocalDate calendarDate,
        String location,
        int maxParticipants
) {
}
