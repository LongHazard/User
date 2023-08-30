package com.ncsgroup.user_service.dao;

import com.ncsgroup.user_service.dto.response.AccountResponse;
import com.ncsgroup.user_service.entity.Account;

public interface AccountDao {
  Account create(String id, String username, String password);

  boolean validateExistByAccount(String username);

  void delete(String accountId);

  AccountResponse update(String accountId, String username, String password);
}
