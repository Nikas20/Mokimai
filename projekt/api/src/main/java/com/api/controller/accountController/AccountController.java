package com.api.controller.accountController;


import com.api.dto.AccauntDTO.AccountRequestDTO;
import com.api.dto.AccauntDTO.AccountRequestMapper;
import com.api.dto.AccauntDTO.AccountResponseMapper;
import com.api.model.Account;
import com.api.model.Role;
import com.api.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
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

  @PostMapping("/register")
  public ResponseEntity<?> addAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are already registered!");
    }
    if (accountService.existsAccountByEmail(accountRequestDTO.email())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account with this email already exists!");
    }

    Account account = new Account();
    account.setEmail(accountRequestDTO.email());
    account.setPassword(passwordEncoder.encode(accountRequestDTO.password()));
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
