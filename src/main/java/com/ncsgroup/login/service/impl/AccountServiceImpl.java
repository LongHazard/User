package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.entity.Account;
import com.ncsgroup.login.exception.DuplicatedUsernameException;
import com.ncsgroup.login.repository.AccountRepository;
import com.ncsgroup.login.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountRepository repository;

  @Override
  public void create(String username, String password) {
    validateExistByAccount(username);
    repository.save(Account.from(username, password));
  }

  private void validateExistByAccount(String username) {
    if (username.length() > 0 && repository.existsByUsername(username))
      throw new DuplicatedUsernameException();
  }
}
