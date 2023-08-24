package com.ncsgroup.user_service.service;

import com.ncsgroup.user_service.dto.response.AccountResponse;

public interface AccountService {
  AccountResponse create(String username, String password);

  void validateExistByAccount(String username);

  void delete(Long accountId);

  void update(Long accountId, String username, String password);
}
