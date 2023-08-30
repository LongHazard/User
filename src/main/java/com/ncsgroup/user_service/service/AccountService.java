package com.ncsgroup.user_service.service;

import com.ncsgroup.user_service.dto.response.AccountResponse;
import com.ncsgroup.user_service.entity.Account;

public interface AccountService {
  Account create(String username, String password);

  void validateExistByAccount(String username);

  void delete(String accountId);

  AccountResponse update(String accountId, String username, String password);
}
