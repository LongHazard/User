package com.ncsgroup.user_service.exception;

import com.ncsgroup.user_service.exception.base.ConflictException;

public class DuplicatedUsernameException extends ConflictException {

  public DuplicatedUsernameException(String objectName) {
    super(objectName);
    setCode("com.ncsgroup.login.exception.DuplicatedUsernameException");
    addParam("name", objectName);
  }
}
