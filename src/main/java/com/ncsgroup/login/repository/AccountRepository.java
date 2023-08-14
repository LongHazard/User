package com.ncsgroup.login.repository;

import com.ncsgroup.login.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  boolean existsAccountByUsername(String username);
}
