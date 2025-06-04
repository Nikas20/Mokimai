package com.api.dto.AccauntDTO;

import com.api.model.Account;
import com.api.model.Role;

import java.util.List;

public class RoleMapper {
  public static List<RoleDTO> toRoleDTOList(Account account) {
    return account.getRoles().stream()
            .map(RoleMapper::toRoleDTO)
            .toList();
  }

  private static RoleDTO toRoleDTO(Role role) {
    return new RoleDTO(role.getId());
  }

  public static List<Role> toRoleListFromDTO(List<RoleDTO> roleDTOList) {
    return roleDTOList.stream().map(RoleMapper::toRole).toList();
  }

  private static Role toRole(RoleDTO roleDTO) {
    Role role = new Role();

    role.setId(roleDTO.id());

    return role;
  }

}
