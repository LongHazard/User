package com.ncsgroup.user_service.controller;

import com.ncsgroup.user_service.dto.common.ResponseGeneral;
import com.ncsgroup.user_service.dto.request.UserRequest;
import com.ncsgroup.user_service.service.MessageService;
import com.ncsgroup.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.ncsgroup.user_service.constant.Constant.LanguageConstants.*;

@Slf4j
@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  private final MessageService messageService;

  @PostMapping()
  public ResponseGeneral<Void> create(
        @RequestBody @Valid UserRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(create) request: {}", request);

    userService.create(request);
    return ResponseGeneral.ofCreated(
          messageService.getMessage(SUCCESS, language)
    );
  }

  @DeleteMapping("{id}")
  public ResponseGeneral<Void> delete(
        @PathVariable(name = "id") String userId,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(delete) id: {}", userId);
    userService.delete(userId);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }

  @PutMapping("{id}")
  public ResponseGeneral<Void> update(
        @PathVariable(name = "id") String userId,
        @RequestBody @Valid UserRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(update) id: {}, request: {}", userId, request);
    userService.update(userId, request);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }


}
