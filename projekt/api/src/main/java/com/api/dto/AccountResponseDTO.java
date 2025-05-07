package com.api.dto;

import java.util.List;

public record AccountResponseDTO(long id,
                                 String email,
                                 List<RoleDTO> roles) {


}
