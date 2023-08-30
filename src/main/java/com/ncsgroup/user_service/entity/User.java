package com.ncsgroup.user_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class User {

  private String id;

  private String email;

  private String phone;

  private String accountId;

  private String fullNameId;

  public static User from(String email, String phone){
    return User.builder().email(email).phone(phone).build();
  }
}
