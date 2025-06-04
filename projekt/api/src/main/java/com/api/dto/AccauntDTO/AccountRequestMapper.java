package com.api.dto.AccauntDTO;

import com.api.model.Account;

public class AccountRequestMapper {


  public static Account toAccount(AccountRequestDTO accountRequestDTO) {
    Account account = new Account();

    account.setEmail(accountRequestDTO.email());
    account.setPassword(accountRequestDTO.password());

    return account;
  }
}
