package com.ncsgroup.login.controller;

import com.ncsgroup.login.dto.request.AccountDTO;
import com.ncsgroup.login.dto.common.ResponseGeneral;
import com.ncsgroup.login.dto.response.AccountResponse;
import com.ncsgroup.login.entity.Account;
import com.ncsgroup.login.service.AccountService;
import com.ncsgroup.login.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.ncsgroup.login.constant.Constant.LanguageConstants.*;

@Slf4j
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;
  private final MessageService messageService;

//  @PostMapping("create")
//  public ResponseGeneral<AccountResponse> create(@RequestBody @Valid AccountDTO request,
//                                                 @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language) {
//    log.info("(create) request: {}", request);
//    Account account = accountService.create(request.getUsername(), request.getPassword());
//    return ResponseGeneral.of(
//          HttpStatus.OK.value(),
//          messageService.getMessage(SUCCESS, language),
//          );
//  }
}
