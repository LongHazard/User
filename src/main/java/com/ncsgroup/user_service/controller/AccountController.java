package com.ncsgroup.user_service.controller;

import com.ncsgroup.user_service.dto.common.ResponseGeneral;
import com.ncsgroup.user_service.dto.request.AccountDTO;
import com.ncsgroup.user_service.entity.Account;
import com.ncsgroup.user_service.service.AccountService;
import com.ncsgroup.user_service.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static com.ncsgroup.user_service.constant.Constant.LanguageConstants.*;

@RestController
@RequestMapping("api/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
  private final AccountService accountService;
  private final MessageService messageService;

  @PostMapping()
  public ResponseGeneral<Account> create(
        @RequestBody @Valid AccountDTO request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) throws SQLException {
    log.info("(create) request: {}", request);
    return ResponseGeneral.ofCreated(
          messageService.getMessage(SUCCESS, language),
          accountService.create(request.getUsername(), request.getPassword())
    );
  }

  @DeleteMapping("/{id}")
  public ResponseGeneral<Void> delete(
        @PathVariable(name = "id") String id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    accountService.delete(id);
    return ResponseGeneral.ofCreated(
          messageService.getMessage(SUCCESS, language)
    );
  }

  @PutMapping("{id}")
  public ResponseGeneral<Void> update(
        @PathVariable(name = "id") String id,
        @RequestBody @Valid AccountDTO request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(update) id: {}, request: {}", id, request);
    accountService.update(id, request.getUsername(), request.getPassword());

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }


}
