package com.ncsgroup.login.exception;

import com.ncsgroup.login.exception.base.ConflictException;

public class DuplicatedUsernameException extends ConflictException {

  public DuplicatedUsernameException(String objectName) {
    super(objectName);
    setCode("com.ncsgroup.login.exception.DuplicatedUsernameException");
    addParam("name", objectName);
  }
}
