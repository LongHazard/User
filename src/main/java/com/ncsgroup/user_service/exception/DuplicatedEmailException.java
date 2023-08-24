package com.ncsgroup.user_service.exception;

import com.ncsgroup.user_service.exception.base.ConflictException;

public class DuplicatedEmailException extends ConflictException {
  public DuplicatedEmailException(String objectName) {
    super(objectName);
    setCode("com.ncsgroup.ntp.exception.DuplicatedEmailException");
    addParam("name", objectName);
  }
}
