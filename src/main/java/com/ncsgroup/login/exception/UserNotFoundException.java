package com.ncsgroup.login.exception;

import com.ncsgroup.login.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
    setCode("com.ncsgroup.login.exception.UserNotFoundException");
    }
}
