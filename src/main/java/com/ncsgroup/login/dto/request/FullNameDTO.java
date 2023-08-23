package com.ncsgroup.login.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FullNameDTO {
  @NotEmpty(message = "First name must be not empty")
  @NotNull(message = "First name must be not null")
  private String firstName;

  @NotEmpty(message = "Middle name must be not empty")
  @NotNull(message = "Middle name must be not null")
  private String middleName;

  @NotEmpty(message = "Last name must be not empty")
  @NotNull(message = "Last name must be not null")
  private String lastName;
}
