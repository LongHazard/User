package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.entity.User;
import com.ncsgroup.login.repository.UserRepository;
import com.ncsgroup.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Override
  public User create(User user) {
    return repository.save(user);
  }
}
