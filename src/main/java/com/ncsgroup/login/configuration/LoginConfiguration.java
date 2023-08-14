package com.ncsgroup.login.configuration;

import com.ncsgroup.login.repository.AccountRepository;
import com.ncsgroup.login.repository.UserRepository;
import com.ncsgroup.login.service.AccountService;
import com.ncsgroup.login.service.UserService;
import com.ncsgroup.login.service.impl.AccountServiceImpl;
import com.ncsgroup.login.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguration {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public UserService userService(UserRepository repository){
    return new UserServiceImpl(repository);
  }

  @Bean
  public AccountService accountService(AccountRepository repository){
    return new AccountServiceImpl(repository);
  }
}
