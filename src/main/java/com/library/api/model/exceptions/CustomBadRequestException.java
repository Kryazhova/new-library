package com.library.api.model.exceptions;

import com.library.api.model.ValidationErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CustomBadRequestException extends RuntimeException {

  private final ValidationErrorResponse response;
}
