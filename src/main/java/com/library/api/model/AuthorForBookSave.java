package com.library.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class AuthorForBookSave {

  @NotNull(message = "Не передан обязательный параметр: id")
  private Long id;
}