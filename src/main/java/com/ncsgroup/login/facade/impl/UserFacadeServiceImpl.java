package com.ncsgroup.login.facade.impl;

import com.ncsgroup.login.dto.request.UserRequest;
import com.ncsgroup.login.dto.response.AccountResponse;
import com.ncsgroup.login.dto.response.FullNameResponse;
import com.ncsgroup.login.dto.response.UserResponse;
import com.ncsgroup.login.entity.Account;
import com.ncsgroup.login.entity.FullName;
import com.ncsgroup.login.entity.User;
import com.ncsgroup.login.facade.UserFacadeService;
import com.ncsgroup.login.service.AccountService;
import com.ncsgroup.login.service.FullNameService;
import com.ncsgroup.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.ncsgroup.login.utils.MapperUtils.MODEL_MAPPER;

@Slf4j
@RequiredArgsConstructor
public class UserFacadeServiceImpl implements UserFacadeService {
  private final AccountService accountService;
  private final FullNameService fullNameService;
  private final UserService userService;


  @Override
  public UserResponse create(UserRequest request) {
    log.info("(create) request: {}", request);
    accountService.validateExistByAccount(request.getUsername());
    User user = userService.create(request.getEmail(), request.getPhone());
    AccountResponse accountResponse= accountService.create(request.getUsername(), request.getPassword());
    FullNameResponse fullNameResponse = fullNameService.create(request.getFirstName(), request.getMiddleName(), request.getLastName());
    user.setAccount(MODEL_MAPPER.map(accountResponse, Account.class));
    user.setFullName(MODEL_MAPPER.map(fullNameResponse, FullName.class));
    userService.save(user);
    return UserResponse.of(
          user.getId(),
          user.getEmail(),
          user.getPhone(),
          accountResponse,
          fullNameResponse
    );
  }
}
