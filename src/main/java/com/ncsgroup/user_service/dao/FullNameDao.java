package com.ncsgroup.user_service.dao;

import com.ncsgroup.user_service.entity.FullName;

public interface FullNameDao {
  FullName create(String fullNameId, String firstName, String middleName, String lastName);

  FullName findById(String id);

  void delete(String fullNameId);

  void update(String fullNameId, String firstName, String middleName, String lastName);
}
