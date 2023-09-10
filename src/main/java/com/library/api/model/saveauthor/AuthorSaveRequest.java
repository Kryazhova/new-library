package com.library.api.model.saveauthor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
@AllArgsConstructor
public class AuthorSaveRequest {

  private Long id;

  @JacksonXmlProperty(localName = "first_name")
  @NotBlank(message = "Не передан обязательный параметр: firstName")
  @Size(min = 1, max = 65, message = "Некорректный размер поля firstName")
  private String firstName;

  @JacksonXmlProperty(localName = "second_name")
  @Size(max = 65, message = "Некорректный размер поля secondName")
  private String secondName;

  @JacksonXmlProperty(localName = "family_name")
  @NotBlank(message = "Не передан обязательный параметр: familyName")
  @Size(min = 1, max = 65, message = "Некорректный размер поля familyName")
  private String familyName;

  @Nullable
  @Pattern(regexp = "^[1-2][0-9]{3}-[0-1][0-9]-[0-3][0-9]$", message = "Неверный формат даты")
  private String birthDate;
}