package com.api.dto.AccauntDTO;

import com.api.model.Account;

public class AccountResponseMapper {
  public static AccountResponseDTO toAccountResponseDTO(Account account) {
    return new AccountResponseDTO(account.getId(), account.getEmail(), RoleMapper.toRoleDTOList(account));
  }
}
