package com.api.dto.AccauntDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AccountRequestDTO(
        @Email(regexp = "^[a-zA-Z0-9._%+-]{4,}@[a-zA-Z0-9.-]{3,}\\.[a-zA-Z]{2,}$",
                message = "Invalid email format, you should have at least 4 symbols before @, at least 3 after @ and before domain, domain at least 2 symbols")
        @Length(min = 11, max = 255, message = "Your email is either too short or too long! Min is 11, max is 255 symbols")
        String email,
        @NotNull(message = "Password can not be null!")
        @Length(min = 6, max = 255, message = "Your password is either too short or too long! Min length is 6, max is 255 symbols")
        String password) {
}
