package com.ncsgroup.login.exception.base;


import static com.ncsgroup.login.constant.Constant.ExceptionStatusConstant.BAD_REQUEST;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode("com.ncsgroup.login.exception.base.BadRequestException");
    setStatus(BAD_REQUEST);
  }

}
