package com.ncsgroup.login.service;

import com.ncsgroup.login.dto.response.FullNameResponse;
import com.ncsgroup.login.entity.FullName;

public interface FullNameService {
  FullName create(String firstName, String middleName, String lastName);
}
