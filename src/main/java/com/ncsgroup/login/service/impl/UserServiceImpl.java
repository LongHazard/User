package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.entity.User;
import com.ncsgroup.login.exception.DuplicatedEmailException;
import com.ncsgroup.login.exception.DuplicatedPhoneNumberException;
import com.ncsgroup.login.exception.UserNotFoundException;
import com.ncsgroup.login.repository.UserRepository;
import com.ncsgroup.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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

    @Override
    public User findById(Long userId) {
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        return user;
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        repository.findById(userId);
    }

    @Override
    public void update(Long userId, String email, String phone) {
        User user = repository.findById(userId).orElse(null);
        if(Objects.nonNull(user)){
            validateInputUpdate(user, email, phone);
            user.setEmail(email);
            user.setPhone(phone);
            repository.save(user);
        }
    }

    private void validateInputUpdate(User user, String email, String phone) {
        if (Objects.nonNull(user.getEmail()) && !user.getEmail().equals(email)) {
            validateExistByEmail(email);
        }
        if (Objects.nonNull(user.getPhone()) && !user.getPhone().equals(phone)) {
            validateExistByPhoneNumber(phone);
        }
    }


    private void validateExistByEmail(String email) {
        if (email.length() > 0 && repository.existsByEmail(email)) throw new DuplicatedEmailException(email);
    }

    private void validateExistByPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 0 && repository.existsByPhone(phoneNumber))
            throw new DuplicatedPhoneNumberException(phoneNumber);
    }
}
