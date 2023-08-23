package com.ncsgroup.login.facade.impl;

import com.ncsgroup.login.dto.request.UserRequest;
import com.ncsgroup.login.facade.UserFacadeService;
import com.ncsgroup.login.service.AccountService;
import com.ncsgroup.login.service.FullNameService;
import com.ncsgroup.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UserFacadeServiceImpl implements UserFacadeService {
  private final AccountService accountService;
  private final FullNameService fullNameService;
  private final UserService userService;


  @Override
  public void create(UserRequest request) {
    log.info("(create) request: {}", request);
    accountService.create(request.getUsername(), request.getPassword());
    fullNameService.create(request.getFirstName(), request.getMiddleName(), request.getLastName());
    userService.create(request.getEmail(), request.getPhone());
  }
}
