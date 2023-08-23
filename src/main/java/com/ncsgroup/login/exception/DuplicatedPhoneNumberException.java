package com.ncsgroup.login.exception;

import com.ncsgroup.login.exception.base.ConflictException;

public class DuplicatedPhoneNumberException extends ConflictException {
  public DuplicatedPhoneNumberException(String object) {
    super(object);
    setCode("com.ncsgroup.ntp.exception.DuplicatedPhoneNumberException");
    addParam("name", object);
  }
}
