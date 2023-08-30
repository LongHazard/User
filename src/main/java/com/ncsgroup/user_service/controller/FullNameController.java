package com.ncsgroup.user_service.controller;

import com.ncsgroup.user_service.dto.common.ResponseGeneral;
import com.ncsgroup.user_service.dto.request.FullNameDTO;
import com.ncsgroup.user_service.service.FullNameService;
import com.ncsgroup.user_service.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static com.ncsgroup.user_service.constant.Constant.LanguageConstants.*;

@RestController
@RequestMapping("api/full_names")
@RequiredArgsConstructor
@Slf4j
public class FullNameController {
  private final FullNameService fullNameService;
  private final MessageService messageService;

  @PostMapping()
  public ResponseGeneral<Void> create(
        @RequestBody @Valid FullNameDTO request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) throws SQLException {
    log.info("(create) request: {}", request);
    fullNameService.create(request.getFirstName(), request.getMiddleName(), request.getFirstName());
    return ResponseGeneral.ofCreated(
          messageService.getMessage(SUCCESS, language)
    );
  }

  @PutMapping("{id}")
  public ResponseGeneral<Void> update(
        @PathVariable(name = "id") String id,
        @RequestBody @Valid FullNameDTO request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(update) id: {}, request: {}", id, request);
    fullNameService.update(id, request.getFirstName(), request.getMiddleName(), request.getLastName());

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }

  @DeleteMapping("{id}")
  public ResponseGeneral<Void> delete(
        @PathVariable(name = "id") String id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(delete) id: {}", id);
    fullNameService.delete(id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }
}
