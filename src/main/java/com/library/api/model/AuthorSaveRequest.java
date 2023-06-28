package com.library.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
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
}