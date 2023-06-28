package com.library.api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Getter;

@Getter
@JacksonXmlRootElement(localName = "Author")
public class AuthorWsdlRequest implements Serializable {

  @JacksonXmlProperty(localName = "author_id")
  @NotNull(message = "Не передан обязательный параметр: authorId")
  private Long authorId;
}