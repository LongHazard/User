package com.ncsgroup.user_service.configuration;

import com.ncsgroup.user_service.dao.AccountDao;
import com.ncsgroup.user_service.dao.impl.AccountDaoImpl;
import com.ncsgroup.user_service.service.AccountService;
import com.ncsgroup.user_service.service.MessageService;
import com.ncsgroup.user_service.service.impl.AccountServiceImpl;
import com.ncsgroup.user_service.service.impl.MessageServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguration {

  @Bean
  public MessageService messageService(MessageSource messageSource){
    return new MessageServiceImpl(messageSource);
  }

  @Bean
  public AccountDao accountDao(){
    return new AccountDaoImpl();
  }

  @Bean
  public AccountService accountService(AccountDao accountDao){
    return new AccountServiceImpl(accountDao);
  }


}
