package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.entity.User;
import com.ncsgroup.user_service.exception.DuplicatedEmailException;
import com.ncsgroup.user_service.exception.DuplicatedPhoneNumberException;
import com.ncsgroup.user_service.exception.UserNotFoundException;
import com.ncsgroup.user_service.repository.UserRepository;
import com.ncsgroup.user_service.service.UserService;
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
        log.info("(create) email: {}, phone: {}", email, phone);

        validateExistByEmail(email);
        validateExistByPhoneNumber(phone);

        return repository.save(User.from(email, phone));
    }

    @Override
    public void save(User user) {
        log.info("(save) user: {}", user);

        repository.save(user);
    }

    @Override
    public User findById(Long userId) {
        log.info("(findById) userId: {}", userId);

        return repository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        log.info("(delete) userId: {}", userId);

        repository.findById(userId);
    }

    @Override
    @Transactional
    public void update(Long userId, String email, String phone) {
        log.info("(update) userId: {}, email: {}, phone: {}", userId, email, phone);

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
        if (repository.existsByEmail(email)) throw new DuplicatedEmailException(email);
    }

    private void validateExistByPhoneNumber(String phoneNumber) {
        if (repository.existsByPhone(phoneNumber))
            throw new DuplicatedPhoneNumberException(phoneNumber);
    }
}
