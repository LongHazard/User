package com.ncsgroup.login.exception.base;


import static com.ncsgroup.login.constant.Constant.ExceptionStatusConstant.NOT_FOUND;

public class NotFoundException extends BaseException {
  public NotFoundException(String id, String objectName) {
    setCode("com.ncsgroup.login.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
    addParam("id", id);
    addParam("objectName", objectName);
  }

  public NotFoundException(String id) {
    setCode("com.ncsgroup.login.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
    addParam("id", id);
  }

  public NotFoundException() {
    setCode("com.ncsgroup.login.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
  }
}
