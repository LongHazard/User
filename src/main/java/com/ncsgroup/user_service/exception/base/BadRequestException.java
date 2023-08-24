package com.ncsgroup.user_service.exception.base;


import static com.ncsgroup.user_service.constant.Constant.ExceptionStatusConstant.BAD_REQUEST;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode("com.ncsgroup.login.exception.base.BadRequestException");
    setStatus(BAD_REQUEST);
  }

}
