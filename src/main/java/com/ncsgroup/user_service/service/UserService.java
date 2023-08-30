package com.ncsgroup.user_service.service;

import com.ncsgroup.user_service.dto.request.UserRequest;
import com.ncsgroup.user_service.dto.response.UserResponse;
import com.ncsgroup.user_service.entity.User;

public interface UserService {
  UserResponse create(UserRequest request);

  void delete(String userId);

  UserResponse update(String userId, UserRequest request);
}
