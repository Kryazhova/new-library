package com.library.controller;

import com.library.api.model.ValidationErrorResponse;
import com.library.api.model.exceptions.CustomBadRequestException;
import com.library.api.model.exceptions.CustomServiceErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Validated
public class ErrorHandlingController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ValidationErrorResponse onMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    return new ValidationErrorResponse("Валидация не пройдена","1001",
        e.getFieldError().getDefaultMessage());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ValidationErrorResponse onHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {
    return new ValidationErrorResponse("1005", "Json некорректный");
  }

  @ExceptionHandler(MissingPathVariableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ValidationErrorResponse onMissingPathVariableException(MissingPathVariableException e) {
    return new ValidationErrorResponse("1001", "Не передан обязательный параметр");
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ValidationErrorResponse onMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException e) {
    return new ValidationErrorResponse("1001", "Некорректный обязательный параметр");
  }

  @ExceptionHandler(CustomBadRequestException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public ValidationErrorResponse onCustomerException(CustomBadRequestException e) {
    return new ValidationErrorResponse(e.getResponse().getErrorCode(),
        e.getResponse().getErrorMessage());
  }

  @ExceptionHandler(CustomServiceErrorException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @ResponseBody
  public ValidationErrorResponse onServiceException(CustomServiceErrorException e) {
    return new ValidationErrorResponse(e.getResponse().getErrorCode(),
        e.getResponse().getErrorMessage());
  }
}