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
  public Account create(String username, String password) {
    validateExistByAccount(username);
    var account = repository.save(Account.of(username, password));
    return Account.from(
          account.getId(),
          username
    );
  }

  @Override
  public void validateExistByAccount(String username) {
    if (username.length() > 0 && repository.existsByUsername(username))
      throw new DuplicatedUsernameException(username);
  }
}
