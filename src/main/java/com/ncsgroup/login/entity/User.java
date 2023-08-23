package com.ncsgroup.login.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", unique = true)
  private String email;
  @Column(name = "phone", unique = true)
  private String phone;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id", referencedColumnName = "id")
  @JsonManagedReference
  private Account account;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "full_name_id", referencedColumnName = "id")
  @JsonManagedReference
  private FullName fullName;

  public static User from(String email, String phone){
    return User.builder().email(email).phone(phone).build();
  }
}
