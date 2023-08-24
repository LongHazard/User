package com.ncsgroup.user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;

  public static Account from(Long id, String username) {
    return Account.builder().id(id).username(username).build();
  }


  public static Account of(String username, String password) {
    return Account.builder().username(username).password(password).build();
  }

}
