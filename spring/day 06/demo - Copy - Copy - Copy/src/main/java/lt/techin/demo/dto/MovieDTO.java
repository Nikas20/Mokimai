package lt.techin.demo.dto;

import jakarta.validation.constraints.*;
import lt.techin.demo.model.Actor;
import lt.techin.demo.model.Screening;

import java.util.List;

public record MovieDTO(long id,
                       @NotBlank
                       @NotEmpty
                       @NotNull
                       @Size(min = 2, max = 150)
                       String title,
                       @NotEmpty
                       @NotNull
                       @Size(min = 2, max = 50)
                       @Pattern(regexp = "^[A-Z][A-z]+$", message = "Must start with uppercase letter, and continue as lowercase" + "and no numbers")
                       String director,
                       @NotNull
                       List<Screening>screenings,
                       @NotNull
                       List<Actor> actors
                       ) {
}
