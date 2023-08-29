package com.ncsgroup.user_service.service;

public interface AccountService {
  void create(String username, String password);

  void validateExistByAccount(String username);

  void delete(Long accountId);

  void update(Long accountId, String username, String password);
}
