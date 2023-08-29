package com.ncsgroup.user_service.controller;

import com.ncsgroup.user_service.dto.common.ResponseGeneral;
import com.ncsgroup.user_service.dto.request.AccountDTO;
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
  public ResponseGeneral<Void> create(
        @RequestBody @Valid AccountDTO request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) throws SQLException {
    log.info("(create) request: {}", request);
    accountService.create(request.getUsername(), request.getPassword());
    return ResponseGeneral.ofCreated(
          messageService.getMessage(SUCCESS, language)
    );
  }

}
