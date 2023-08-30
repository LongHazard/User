package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.dao.UserDao;
import com.ncsgroup.user_service.dto.request.UserRequest;
import com.ncsgroup.user_service.entity.Account;
import com.ncsgroup.user_service.entity.FullName;
import com.ncsgroup.user_service.entity.User;
import com.ncsgroup.user_service.service.AccountService;
import com.ncsgroup.user_service.service.FullNameService;
import com.ncsgroup.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserDao userDao;
  private final AccountService accountService;
  private final FullNameService fullNameService;

  @Override
  public void create(UserRequest request) {
    String id = UUID.randomUUID().toString();
    Account account = accountService.create(request.getUsername(), request.getPassword());
    FullName fullName = fullNameService.create(request.getFirstName(), request.getMiddleName(), request.getLastName());
    userDao.create(id, request.getEmail(), request.getPhone(), account.getId(), fullName.getId());
  }


  @Override
  public void delete(String userId) {
    User user = userDao.findById(userId);
    accountService.delete(user.getAccountId());
    fullNameService.delete(user.getFullNameId());
    userDao.delete(userId);
  }

  @Override
  public void update(String userId, UserRequest request) {
    User user = userDao.findById(userId);
    accountService.update(user.getAccountId(), request.getUsername(), request.getPassword());
    fullNameService.update(user.getFullNameId(), request.getFirstName(), request.getMiddleName(), request.getLastName());
    userDao.update(userId, request.getEmail(), request.getPhone());
  }


}
