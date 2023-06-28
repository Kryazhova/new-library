package com.library.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookSaveRequest {

  @NotBlank(message = "Не передан обязательный параметр: bookTitle")
  @Size(min = 1, max = 50, message = "Некорректный размер поля firstName")
  private String bookTitle;

  @NotNull(message = "Не передан обязательный параметр: author")
  private AuthorForBookSave author;
}
