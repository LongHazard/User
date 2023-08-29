package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.dao.AccountDao;
import com.ncsgroup.user_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountDao accountDao;

  @Override
  public void create(String username, String password) {
    String id = UUID.randomUUID().toString();

    this.validateExistByAccount(username);
    accountDao.create(id, username, password);
  }

  @Override
  public void validateExistByAccount(String username) {
    accountDao.validateExistByAccount(username);
  }

  @Override
  public void delete(Long accountId) {

  }

  @Override
  public void update(Long accountId, String username, String password) {

  }

}
