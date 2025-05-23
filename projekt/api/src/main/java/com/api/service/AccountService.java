package com.api.service;

import com.api.model.Account;
import com.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account findByEmail(String email) {
    return accountRepository.findByEmail(email);
  }

  public boolean existsAccountByEmail(String email) {
    return accountRepository.existsByEmail(email);
  }

  public Account saveAccount(Account account) {
    return accountRepository.save(account);
  }
}
