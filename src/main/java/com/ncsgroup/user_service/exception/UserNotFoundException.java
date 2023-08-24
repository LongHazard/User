package com.ncsgroup.user_service.exception;

import com.ncsgroup.user_service.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
    setCode("com.ncsgroup.login.exception.UserNotFoundException");
    }
}
