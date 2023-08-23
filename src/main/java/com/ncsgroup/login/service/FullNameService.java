package com.ncsgroup.login.service;

import com.ncsgroup.login.dto.request.FullNameDTO;
import com.ncsgroup.login.dto.response.FullNameResponse;
import com.ncsgroup.login.entity.FullName;

public interface FullNameService {
  FullNameResponse create(String firstName, String middleName, String lastName);

  void delete(Long fullNameId);

  void update(Long fullNameId, String firstName, String middleName, String lastName);
}
