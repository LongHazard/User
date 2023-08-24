package com.ncsgroup.user_service.facade;

import com.ncsgroup.user_service.dto.request.UserRequest;
import com.ncsgroup.user_service.dto.response.UserResponse;

public interface UserFacadeService {
  UserResponse create(UserRequest request);

  void delete(Long userId);

  void update(Long userId, UserRequest request);
}
