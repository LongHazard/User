package com.ncsgroup.login.service.impl;

import com.ncsgroup.login.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
  private final MessageSource messageSource;

  public String getMessage(String code, String language) {
    try {
      return messageSource.getMessage(code, null, new Locale(language));
    } catch (Exception ex) {
      return code;
    }
  }
}

