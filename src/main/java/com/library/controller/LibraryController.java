package com.library.controller;

import com.library.api.LibraryV1;
import com.library.api.model.AuthorWsdlRequest;
import com.library.api.model.BookListResponse;
import com.library.api.model.BookResponse;
import com.library.service.LibraryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LibraryController implements LibraryV1 {

  private final LibraryService libraryService;

  @Override
  public List<BookResponse> getAllBooksByAuthor(long authorId) {
    return libraryService.getAllBooksByAuthor(authorId);
  }

  @Override
  public BookListResponse getAllBooksByAuthor(AuthorWsdlRequest request) {
    return libraryService.getAllBooksByAuthor(request);
  }
}