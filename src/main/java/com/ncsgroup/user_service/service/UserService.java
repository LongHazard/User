package com.ncsgroup.user_service.service;

import com.ncsgroup.user_service.entity.User;

public interface UserService {
  User create(String email, String phone);

  void save(User user);

  User findById(Long userId);

  void delete(Long userId);

  void update(Long userId, String email, String phone);
}
