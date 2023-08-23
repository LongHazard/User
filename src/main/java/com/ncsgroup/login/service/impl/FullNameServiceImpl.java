package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.dto.response.FullNameResponse;
import com.ncsgroup.login.entity.FullName;
import com.ncsgroup.login.repository.FullNameRepository;
import com.ncsgroup.login.service.FullNameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
  private final FullNameRepository repository;

  @Override
  public FullName create(String firstName, String middleName, String lastName) {
    var fullName = repository.save(FullName.from(firstName, middleName, lastName));
    return fullName;
  }


}
