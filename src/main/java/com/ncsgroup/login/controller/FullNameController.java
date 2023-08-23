package com.ncsgroup.login.controller;

import com.ncsgroup.login.dto.request.FullNameDTO;
import com.ncsgroup.login.dto.common.ResponseGeneral;
import com.ncsgroup.login.service.FullNameService;
import com.ncsgroup.login.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.ncsgroup.login.constant.Constant.LanguageConstants.*;

@Slf4j
@RestController
@RequestMapping("full_name")
@RequiredArgsConstructor
public class FullNameController {
  private final FullNameService fullNameService;
  private final MessageService messageService;

  @PostMapping("create")
  public ResponseGeneral<Void> create(@RequestBody FullNameDTO request,
                                      @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language) {
    fullNameService.create(request.getFirstName(), request.getMiddleName(), request.getLastName());
    return ResponseGeneral.ofSuccess(messageService.getMessage(SUCCESS, language));
  }
}
