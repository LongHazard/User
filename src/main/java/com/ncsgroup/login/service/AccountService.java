package com.ncsgroup.login.service;

import com.ncsgroup.login.dto.response.AccountResponse;
import com.ncsgroup.login.entity.Account;

public interface AccountService {
  AccountResponse create(String username, String password);

  void validateExistByAccount(String username);
}
