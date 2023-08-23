package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.dto.request.FullNameDTO;
import com.ncsgroup.login.dto.response.FullNameResponse;
import com.ncsgroup.login.entity.FullName;
import com.ncsgroup.login.repository.FullNameRepository;
import com.ncsgroup.login.service.FullNameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
  private final FullNameRepository repository;

  @Override
  public FullNameResponse create(String firstName, String middleName, String lastName) {
    var fullName = repository.save(FullName.from(firstName, middleName, lastName));
    return FullNameResponse.of(
          fullName.getId(),
          firstName,
          middleName,
          lastName
    );
  }

  @Override
  @Transactional
  public void delete(Long fullNameId) {
    repository.deleteById(fullNameId);
  }

  @Override
  @Transactional
  public void update(Long fullNameId, String firstName, String middleName, String lastName) {
    FullName fullName = repository.findById(fullNameId).orElse(null);
    if(Objects.nonNull(fullName)){
      fullName.setFirstName(firstName);
      fullName.setMiddleName(middleName);
      fullName.setLastName(lastName);
    }
    repository.save(fullName);
  }


}
