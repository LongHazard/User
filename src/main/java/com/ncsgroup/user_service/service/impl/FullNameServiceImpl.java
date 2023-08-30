package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.dao.FullNameDao;
import com.ncsgroup.user_service.entity.FullName;
import com.ncsgroup.user_service.service.FullNameService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
  private final FullNameDao fullNameDao;

  @Override
  public FullName create(String firstName, String middleName, String lastName) {
    String id = UUID.randomUUID().toString();
    return  fullNameDao.create(id, firstName, middleName, lastName);
  }

  @Override
  public void delete(String fullNameId) {
    fullNameDao.delete(fullNameId);
  }

  @Override
  public void update(String fullNameId, String firstName, String middleName, String lastName) {
    fullNameDao.update(fullNameId, firstName, middleName, lastName);
  }
}