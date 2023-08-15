package com.ncsgroup.login.service;

import com.ncsgroup.login.entity.User;

public interface UserService {
  User create(String email, String phone);
}
