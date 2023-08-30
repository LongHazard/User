package com.ncsgroup.user_service.service;

import com.ncsgroup.user_service.dto.request.UserRequest;
import com.ncsgroup.user_service.entity.User;

public interface UserService {
  void create(UserRequest request);

  void delete(String userId);

  void update(String userId, UserRequest request);
}
