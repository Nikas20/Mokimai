package com.api.dto;

import com.api.model.Account;

import java.util.ArrayList;

public class AccountRequestMapper {


  public static Account toAccount(AccountRequestDTO accountRequestDTO) {
    Account account = new Account();

    account.setEmail(accountRequestDTO.email());
    account.setPassword(accountRequestDTO.password());

    return account;
  }
}
