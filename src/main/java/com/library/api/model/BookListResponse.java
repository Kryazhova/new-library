package com.library.api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "BookListResponse")
@JacksonXmlRootElement(localName = "authors_books")
public class BookListResponse {

  @JacksonXmlElementWrapper(localName = "books")
  @XmlElement(name = "book")
  private List<BookResponse> book;

}
