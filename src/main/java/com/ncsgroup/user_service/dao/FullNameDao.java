package com.ncsgroup.user_service.dao;

import com.ncsgroup.user_service.dto.response.FullNameResponse;
import com.ncsgroup.user_service.entity.FullName;

public interface FullNameDao {
  FullName create(String fullNameId, String firstName, String middleName, String lastName);

  void delete(String fullNameId);

  FullNameResponse update(String fullNameId, String firstName, String middleName, String lastName);
}
