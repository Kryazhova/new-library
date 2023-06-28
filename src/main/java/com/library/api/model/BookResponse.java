package com.library.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JacksonXmlRootElement(localName = "book")
public class BookResponse {

  @JacksonXmlProperty(localName = "book_title")
  private String bookTitle;

  private AuthorSaveRequest author;
}
