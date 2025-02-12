package lt.techin.demo.dto;

import lt.techin.demo.model.Role;

import java.util.List;

public record UserDTO(long id, String username, List<Role> roles,
                      java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
}
