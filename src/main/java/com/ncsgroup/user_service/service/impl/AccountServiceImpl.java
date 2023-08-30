package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.dao.AccountDao;
import com.ncsgroup.user_service.entity.Account;
import com.ncsgroup.user_service.exception.DuplicatedUsernameException;
import com.ncsgroup.user_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountDao accountDao;

  @Override
  public Account create(String username, String password) {
    String id = UUID.randomUUID().toString();
    this.validateExistByAccount(username);
    return accountDao.create(id, username, password);
  }

  @Override
  public void validateExistByAccount(String username) {
    if (accountDao.validateExistByAccount(username) == true){
      throw new DuplicatedUsernameException(username);
    }
  }

  @Override
  public void delete(String accountId) {
    accountDao.delete(accountId);
  }

  @Override
  public void update(String accountId, String username, String password) {
    accountDao.update(accountId, username, password);
  }

}
