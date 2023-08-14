package com.ncsgroup.login.service;

import com.ncsgroup.login.dto.AccountDTO;
import com.ncsgroup.login.entity.Account;

public interface AccountService {
  void create(AccountDTO request);
}
