package com.ncsgroup.user_service.dao;

import com.ncsgroup.user_service.entity.Account;

import java.sql.SQLException;

public interface AccountDao {
  Account create(String id, String username, String password) ;

  Account findById(String id);

  boolean validateExistByAccount(String username);

  void delete(String accountId);

  void update(String accountId, String username, String password);
}
