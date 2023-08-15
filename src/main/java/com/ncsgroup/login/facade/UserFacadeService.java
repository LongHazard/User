package com.ncsgroup.login.facade;

import com.ncsgroup.login.dto.UserRequest;

public interface UserFacadeService {
  void create(UserRequest request);
}
