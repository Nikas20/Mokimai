package com.api.repository;

import com.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

  Account findByEmail(String email);

  boolean existsByEmail(String email);
}