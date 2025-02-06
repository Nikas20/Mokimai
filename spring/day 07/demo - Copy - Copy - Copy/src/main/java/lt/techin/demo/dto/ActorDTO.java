package lt.techin.demo.dto;

import jakarta.validation.constraints.Size;
import lt.techin.demo.validation.Name;

public record ActorDTO(
        long id,
        @Size(min = 2, max = 50)
        @Name
        String firstName,
        @Size(min = 2, max = 50)
        @Name
        String lastName
) {
}
