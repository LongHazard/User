package com.ncsgroup.login.exception.base;

import static com.ncsgroup.login.constant.Constant.ExceptionStatusConstant.CONFLICT;

public class ConflictException extends BaseException {
  public ConflictException(String objectName) {
    setCode("com.ncsgroup.login.exception.base.ConflictException");
    setStatus(CONFLICT);
    addParam("objectName", objectName);
  }
}
