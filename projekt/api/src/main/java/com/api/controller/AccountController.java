package com.api.controller;


import com.api.dto.AccountRequestDTO;
import com.api.dto.AccountRequestMapper;
import com.api.dto.AccountResponseMapper;
import com.api.model.Account;
import com.api.model.Role;
import com.api.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

  private final AccountService accountService;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public AccountController(AccountService accountService, PasswordEncoder passwordEncoder) {
    this.accountService = accountService;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/account")
  public ResponseEntity<?> addAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are already registered!");
    }
    if (accountService.existsAccountByEmail(accountRequestDTO.email())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account with this email already exists!");
    }

    Account account = AccountRequestMapper.toAccount(accountRequestDTO);


    account.setPassword(passwordEncoder.encode(account.getPassword()));
    account.setRoles(List.of(new Role("USER", 1)));

    Account savedAccount = accountService.saveAccount(account);


    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedAccount.getId())
                            .toUri())
            .body(AccountResponseMapper.toAccountResponseDTO(savedAccount));
  }
}
