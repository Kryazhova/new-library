package com.library.api.model.exceptions;

import com.library.api.model.ValidationErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CustomServiceErrorException extends RuntimeException {

  ValidationErrorResponse response;
}
