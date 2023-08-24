package com.ncsgroup.user_service.service;

import com.ncsgroup.user_service.dto.response.FullNameResponse;

public interface FullNameService {
  FullNameResponse create(String firstName, String middleName, String lastName);

  void delete(Long fullNameId);

  void update(Long fullNameId, String firstName, String middleName, String lastName);
}
