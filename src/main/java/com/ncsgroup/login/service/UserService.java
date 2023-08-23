package com.ncsgroup.login.service;

import com.ncsgroup.login.entity.User;

public interface UserService {
  User create(String email, String phone);

  void save(User user);

  User findById(Long userId);

  void delete(Long userId);

  void update(Long userId, String email, String phone);
}
