package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.dto.response.FullNameResponse;
import com.ncsgroup.user_service.entity.FullName;
import com.ncsgroup.user_service.repository.FullNameRepository;
import com.ncsgroup.user_service.service.FullNameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
  private final FullNameRepository repository;

  @Override
  @Transactional
  public FullNameResponse create(String firstName, String middleName, String lastName) {
    log.info("(create) firstName: {}, middleName: {}, lastName: {}", firstName, middleName, lastName);

    FullName fullName = repository.save(FullName.from(firstName, middleName, lastName));

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
    log.info("(delete) fullNameId: {}", fullNameId);

    repository.deleteById(fullNameId);
  }

  @Override
  @Transactional
  public void update(Long fullNameId, String firstName, String middleName, String lastName) {
    log.info("(update) fullNameId: {}, firstName: {}, middleName: {}, lastName: {}",fullNameId, firstName, middleName, lastName);

    FullName fullName = repository.findById(fullNameId).orElse(null);

    if(Objects.nonNull(fullName)){
      fullName.setFirstName(firstName);
      fullName.setMiddleName(middleName);
      fullName.setLastName(lastName);
    }
    repository.save(fullName);
  }


}
