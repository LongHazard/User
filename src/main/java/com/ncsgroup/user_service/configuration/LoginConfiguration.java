package com.ncsgroup.user_service.configuration;

import com.ncsgroup.user_service.dao.AccountDao;
import com.ncsgroup.user_service.dao.FullNameDao;
import com.ncsgroup.user_service.dao.UserDao;
import com.ncsgroup.user_service.dao.impl.AccountDaoImpl;
import com.ncsgroup.user_service.dao.impl.FullNameDaoImpl;
import com.ncsgroup.user_service.dao.impl.UserDaoImpl;
import com.ncsgroup.user_service.service.AccountService;
import com.ncsgroup.user_service.service.FullNameService;
import com.ncsgroup.user_service.service.MessageService;
import com.ncsgroup.user_service.service.UserService;
import com.ncsgroup.user_service.service.impl.AccountServiceImpl;
import com.ncsgroup.user_service.service.impl.FullNameServiceImpl;
import com.ncsgroup.user_service.service.impl.MessageServiceImpl;
import com.ncsgroup.user_service.service.impl.UserServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguration {

  @Bean
  public MessageService messageService(MessageSource messageSource) {
    return new MessageServiceImpl(messageSource);
  }

  @Bean
  public AccountDao accountDao() {
    return new AccountDaoImpl();
  }

  @Bean
  public AccountService accountService(AccountDao accountDao) {
    return new AccountServiceImpl(accountDao);
  }

  @Bean
  public FullNameDao fullNameDao() {
    return new FullNameDaoImpl();
  }

  @Bean
  public FullNameService fullNameService(FullNameDao fullNameDao) {
    return new FullNameServiceImpl(fullNameDao);
  }

  @Bean
  public UserDao userDao() {
    return new UserDaoImpl();
  }

  @Bean
  public UserService userService(
        UserDao userDao,
        AccountService accountService,
        FullNameService fullNameService
  ) {
    return new UserServiceImpl(
          userDao,
          accountService,
          fullNameService
    );
  }


}
