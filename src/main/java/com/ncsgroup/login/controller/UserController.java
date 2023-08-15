package com.ncsgroup.login.controller;

import com.ncsgroup.login.dto.ResponseGeneral;
import com.ncsgroup.login.dto.UserRequest;
import com.ncsgroup.login.facade.UserFacadeService;
import com.ncsgroup.login.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.ncsgroup.login.constant.Constant.LanguageConstants.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final UserFacadeService userFacadeService;
  private final MessageService messageService;

  @PostMapping("/create")
  public ResponseGeneral<Void> create(
        @RequestBody UserRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(create) request: {}", request);
    userFacadeService.create(request);
    return ResponseGeneral.ofSuccess(messageService.getMessage(SUCCESS, language));
  }


}
