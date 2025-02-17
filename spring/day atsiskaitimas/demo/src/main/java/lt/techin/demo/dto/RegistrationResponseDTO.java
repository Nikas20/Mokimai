package lt.techin.demo.dto;


import lt.techin.demo.model.RunningEvent;
import lt.techin.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

public record RegistrationResponseDTO(
        long id,
        long userId,
        String eventName,
        LocalDateTime registrationDate
) {

}
