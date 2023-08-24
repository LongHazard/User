package com.ncsgroup.user_service.exception.base;

import static com.ncsgroup.user_service.constant.Constant.ExceptionStatusConstant.CONFLICT;

public class ConflictException extends BaseException {
  public ConflictException(String objectName) {
    setCode("com.ncsgroup.login.exception.base.ConflictException");
    setStatus(CONFLICT);
    addParam("objectName", objectName);
  }
}
