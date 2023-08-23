package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.entity.User;
import com.ncsgroup.login.exception.DuplicatedEmailException;
import com.ncsgroup.login.exception.DuplicatedPhoneNumberException;
import com.ncsgroup.login.repository.UserRepository;
import com.ncsgroup.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Override
  public User create(String email, String phone) {
    validateExistByEmail(email);
    validateExistByPhoneNumber(phone);
    return repository.save(User.from(email, phone));
  }

  @Override
  public void save(User user) {
    repository.save(user);
  }

  private void validateExistByEmail(String email) {
    if (email.length() > 0 && repository.existsByEmail(email)) throw new DuplicatedEmailException(email);
  }

  private void validateExistByPhoneNumber(String phoneNumber) {
    if (phoneNumber.length() > 0 && repository.existsByPhone(phoneNumber))
      throw new DuplicatedPhoneNumberException(phoneNumber);
  }
}
