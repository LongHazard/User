package com.ncsgroup.user_service.service.impl;

import com.ncsgroup.user_service.dto.response.AccountResponse;
import com.ncsgroup.user_service.entity.Account;
import com.ncsgroup.user_service.exception.DuplicatedUsernameException;
import com.ncsgroup.user_service.repository.AccountRepository;
import com.ncsgroup.user_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Override
    @Transactional
    public AccountResponse create(String username, String password) {
        log.info("(create) username: {}, password: {}", username, password);

        validateExistByAccount(username);

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        repository.save(account);
        return AccountResponse.from(
                account.getId(),
                username
        );
    }

    @Override
    public void validateExistByAccount(String username) {
        if (repository.existsByUsername(username))
            throw new DuplicatedUsernameException(username);
    }

    @Override
    @Transactional
    public void delete(Long accountId) {
        log.info("(delete) accountId: {}", accountId);
        repository.deleteById(accountId);
    }

    @Override
    @Transactional
    public void update(Long accountId, String username, String password) {
        log.info("(update) accountId: {}, username: {}, password: {}", accountId, username, password);

        Optional<Account> account = repository.findById(accountId);

        if (!account.get().getUsername().equals(username)) {
            validateExistByAccount(username);
            account.get().setUsername(username);
            account.get().setPassword(password);
            repository.save(account.get());
        }
    }
}
