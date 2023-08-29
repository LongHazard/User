package com.ncsgroup.user_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullName {
  private String  id;

  private String firstName;

  private String middleName;

  private String lastName;

  public static FullName from(String firstName, String middleName, String lastName){
    return FullName.builder().firstName(firstName).middleName(middleName).lastName(lastName).build();
  }

}
