package com.ncsgroup.login.controller;

import com.ncsgroup.login.dto.AccountDTO;
import com.ncsgroup.login.dto.ResponseGeneral;
import com.ncsgroup.login.service.AccountService;
import com.ncsgroup.login.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.ncsgroup.login.constant.Constant.LanguageConstants.*;

@Slf4j
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;
  private final MessageService messageService;
  
  @PostMapping("create")
  public ResponseGeneral<Void> create(@RequestBody AccountDTO request,
                                      @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language){
    accountService.create(request.getUsername(), request.getPassword());
    return ResponseGeneral.ofSuccess(messageService.getMessage(SUCCESS, language));
  }
}
