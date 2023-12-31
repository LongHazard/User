package com.ncsgroup.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@Data
@NoArgsConstructor
public class ErrorResponse {
  private int status;
  private String code;
  private Object data;
}
