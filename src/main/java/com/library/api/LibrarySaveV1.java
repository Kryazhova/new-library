package com.library.api;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.library.api.model.AuthorSaveRequest;
import com.library.api.model.AuthorSaveResponse;
import com.library.api.model.BookSaveRequest;
import com.library.api.model.BookSaveResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("library")
public interface LibrarySaveV1 {

  @PostMapping(value = "/authors/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public AuthorSaveResponse saveAuthor(@RequestBody @Valid AuthorSaveRequest request);

  @PostMapping(value = "/books/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public BookSaveResponse saveBooks(@RequestBody @Valid BookSaveRequest book);
}
