package com.ncsgroup.login.service;

import com.ncsgroup.login.dto.FullNameDTO;

public interface FullNameService {
  void create(String firstName, String middleName, String lastName);
}
