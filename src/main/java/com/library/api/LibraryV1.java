package com.library.api;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

import com.library.api.model.AuthorWsdlRequest;
import com.library.api.model.BookListResponse;
import com.library.api.model.BookResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("library")
public interface LibraryV1 {

  @GetMapping(value = "/authors/{authorId}/books", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<BookResponse> getAllBooksByAuthor(
      @PathVariable(name = "authorId", required = true) long authorId);

  @PostMapping(value = "/authors/books", produces = APPLICATION_XML_VALUE)
  @ResponseBody
  public BookListResponse getAllBooksByAuthor(@RequestBody @Valid AuthorWsdlRequest request);
}
