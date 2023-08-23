package com.ncsgroup.login.facade;

import com.ncsgroup.login.dto.request.UserRequest;
import com.ncsgroup.login.dto.response.UserResponse;

public interface UserFacadeService {
  UserResponse create(UserRequest request);
}
