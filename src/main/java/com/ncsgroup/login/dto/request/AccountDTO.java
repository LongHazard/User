package com.ncsgroup.login.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
  @NotEmpty(message = "Username must be not empty")
  @NotNull(message = "Username must be not null")
  private String username;
  private String password;
}
