package com.ncsgroup.login.configuration;

import com.ncsgroup.login.facade.UserFacadeService;
import com.ncsgroup.login.facade.impl.UserFacadeServiceImpl;
import com.ncsgroup.login.repository.AccountRepository;
import com.ncsgroup.login.repository.FullNameRepository;
import com.ncsgroup.login.repository.UserRepository;
import com.ncsgroup.login.service.AccountService;
import com.ncsgroup.login.service.FullNameService;
import com.ncsgroup.login.service.MessageService;
import com.ncsgroup.login.service.UserService;
import com.ncsgroup.login.service.impl.AccountServiceImpl;
import com.ncsgroup.login.service.impl.FullNameServiceImpl;
import com.ncsgroup.login.service.impl.MessageServiceImpl;
import com.ncsgroup.login.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguration {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public UserService userService(UserRepository repository) {
    return new UserServiceImpl(repository);
  }

  @Bean
  public AccountService accountService(AccountRepository repository) {
    return new AccountServiceImpl(repository);
  }

  @Bean
  public FullNameService fullNameService(FullNameRepository repository) {
    return new FullNameServiceImpl(repository);
  }

  @Bean
  public MessageService messageService(MessageSource messageSource){
    return new MessageServiceImpl(messageSource);
  }

  @Bean
  public UserFacadeService userFacadeService(
        AccountService accountService,
        FullNameService fullNameService,
        UserService userService
  ) {
    return new UserFacadeServiceImpl(
          accountService,
          fullNameService,
          userService
    );
  }
}
