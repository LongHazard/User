package com.ncsgroup.login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class AccountResponse {
  private Long id;
  private String username;
  private String password;
}
