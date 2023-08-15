package com.ncsgroup.login.exception;

import com.ncsgroup.login.exception.base.BadRequestException;
import com.ncsgroup.login.exception.base.ConflictException;

public class DuplicatedUsernameException extends BadRequestException {

  public DuplicatedUsernameException() {
    setCode("com.ncsgroup.login.exception.DuplicatedUsernameException");
  }
}
