package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.dto.response.AccountResponse;
import com.ncsgroup.login.entity.Account;
import com.ncsgroup.login.exception.DuplicatedUsernameException;
import com.ncsgroup.login.repository.AccountRepository;
import com.ncsgroup.login.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Override
    public AccountResponse create(String username, String password) {
        validateExistByAccount(username);
        Account account = Account.of(username, password);
        repository.save(account);
        return AccountResponse.from(
                account.getId(),
                username
        );
    }

    @Override
    public void validateExistByAccount(String username) {
        if (username.length() > 0 && repository.existsByUsername(username))
            throw new DuplicatedUsernameException(username);
    }

    @Override
    @Transactional
    public void delete(Long accountId) {
        repository.deleteById(accountId);
    }

    @Override
    @Transactional
    public void update(Long accountId, String username, String password) {
        Optional<Account> account = repository.findById(accountId);
        if (!account.get().getUsername().equals(username)) {
            validateExistByAccount(username);
            account.get().setUsername(username);
            account.get().setPassword(password);
            repository.save(account.get());
        }
    }
}
