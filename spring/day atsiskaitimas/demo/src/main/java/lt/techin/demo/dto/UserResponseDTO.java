package lt.techin.demo.dto;

import lt.techin.demo.model.Role;

import java.util.List;

public record UserResponseDTO(
        long id,
        String username,
        List<Role> roles
) {
}
