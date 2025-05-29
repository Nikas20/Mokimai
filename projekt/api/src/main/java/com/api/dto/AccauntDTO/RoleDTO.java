package com.api.dto.AccauntDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RoleDTO(@NotNull
                      @NotEmpty
                      long id) {


}
