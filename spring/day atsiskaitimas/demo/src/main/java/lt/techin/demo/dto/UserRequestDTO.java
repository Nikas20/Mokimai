package lt.techin.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lt.techin.demo.model.Role;

import java.util.List;

public record UserRequestDTO(
        @NotNull
        @Size(min = 4, max = 100, message = "Minimum 4 Maximum 100 characters")
        @Pattern(regexp = "^[a-z0-9]+$", message = "Must be a lowercase letters, numbers allowed")
        String username,

        @NotNull
        @Size(min = 6, max = 150, message = "Minimum 6 Maximum 150 characters")
        String password,

        @NotNull
        List<Role> roles
) {
}
