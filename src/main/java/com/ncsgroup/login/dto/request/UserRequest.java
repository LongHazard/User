package com.ncsgroup.login.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ncsgroup.login.annotation.ValidationEmail;
import com.ncsgroup.login.annotation.ValidationPhoneNumber;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRequest {
  @ValidationEmail
  private String email;
  @ValidationPhoneNumber
  private String phone;

  @NotEmpty(message = "Username must be not empty")
  @NotNull(message = "Username must be not null")
  private String username;

  private String password;

  private String firstName;

  private String middleName;

  private String lastName;
}
