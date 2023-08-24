package com.ncsgroup.user_service.exception;

import com.ncsgroup.user_service.exception.base.ConflictException;

public class DuplicatedPhoneNumberException extends ConflictException {
  public DuplicatedPhoneNumberException(String object) {
    super(object);
    setCode("com.ncsgroup.ntp.exception.DuplicatedPhoneNumberException");
    addParam("name", object);
  }
}
