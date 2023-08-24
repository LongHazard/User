package com.ncsgroup.user_service.configuration;

import com.ncsgroup.user_service.facade.UserFacadeService;
import com.ncsgroup.user_service.facade.impl.UserFacadeServiceImpl;
import com.ncsgroup.user_service.repository.AccountRepository;
import com.ncsgroup.user_service.repository.FullNameRepository;
import com.ncsgroup.user_service.repository.UserRepository;
import com.ncsgroup.user_service.service.AccountService;
import com.ncsgroup.user_service.service.FullNameService;
import com.ncsgroup.user_service.service.MessageService;
import com.ncsgroup.user_service.service.UserService;
import com.ncsgroup.user_service.service.impl.AccountServiceImpl;
import com.ncsgroup.user_service.service.impl.FullNameServiceImpl;
import com.ncsgroup.user_service.service.impl.MessageServiceImpl;
import com.ncsgroup.user_service.service.impl.UserServiceImpl;
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
