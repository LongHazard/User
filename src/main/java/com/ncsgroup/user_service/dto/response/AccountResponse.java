package com.ncsgroup.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class AccountResponse {
  private Long id;
  private String username;

  public static AccountResponse from(Long id, String username){
    return AccountResponse.builder().id(id).username(username).build();
  }
}
