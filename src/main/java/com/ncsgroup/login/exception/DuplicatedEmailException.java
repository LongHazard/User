package com.ncsgroup.login.exception;

import com.ncsgroup.login.exception.base.ConflictException;

public class DuplicatedEmailException extends ConflictException {
  public DuplicatedEmailException(String objectName) {
    super(objectName);
    setCode("com.ncsgroup.ntp.exception.DuplicatedEmailException");
    addParam("name", objectName);
  }
}
