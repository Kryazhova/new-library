package com.library.service;

import com.library.api.model.AuthorSaveRequest;
import com.library.api.model.AuthorSaveResponse;
import com.library.api.model.AuthorWsdlRequest;
import com.library.api.model.BookListResponse;
import com.library.api.model.BookSaveRequest;
import com.library.api.model.BookResponse;
import com.library.api.model.BookSaveResponse;
import com.library.api.model.ValidationErrorResponse;
import com.library.api.model.exceptions.CustomBadRequestException;
import com.library.api.model.exceptions.CustomServiceErrorException;
import com.library.db.entity.AuthorEntity;
import com.library.db.entity.BookEntity;
import com.library.db.repository.AuthorRepository;
import com.library.db.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LibraryService {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorRepository authorRepository;

  public BookListResponse getAllBooksByAuthor(AuthorWsdlRequest request) {
    return new BookListResponse().setBook(getAllBooksByAuthor(request.getAuthorId()));
  }

  public List<BookResponse> getAllBooksByAuthor(long authorId) {

    List<BookResponse> books = new ArrayList<>();

    if (authorRepository.findById(authorId).isEmpty()) {
      throw new CustomBadRequestException(
          new ValidationErrorResponse("1004", "Указанный автор не существует в таблице"));
    }

    log.info("Поиск книг по указанному автору");
    try {
      List<BookEntity> bookEntities = bookRepository.findAllByAuthor_Id(authorId);
      log.info("Найдено книг: " + bookEntities.size());

      for (BookEntity book : bookEntities) {
        AuthorEntity author = book.getAuthor();
        books.add(new BookResponse(book.getBookTitle(),
            new AuthorSaveRequest(author.getId(), author.getFirstName(), author.getSecondName(),
                author.getFamilyName())));
      }

    } catch (Exception e) {
      throw new CustomServiceErrorException(
          new ValidationErrorResponse("1005", "Ошибка получения данных"));
    }

    return books;
  }

  public AuthorSaveResponse saveAuthor(AuthorSaveRequest request) {

    AuthorEntity author = new AuthorEntity();

    Optional<AuthorEntity> authorEntities = authorRepository.findByFirstNameAndFamilyName(
        request.getFirstName(), request.getFamilyName());
    log.info("Выполнен поиск автора: ".concat(authorEntities.toString()));

    if (authorEntities.isPresent()) {
      log.info("Автор уже найден");
      throw new CustomBadRequestException(
          new ValidationErrorResponse("1002", "Указанный автор уже добавлен в базу данных"));
    }

    try {
      log.info("Сохранение автора.");
      author
          .setFirstName(request.getFirstName())
          .setSecondName(request.getSecondName())
          .setFamilyName(request.getFamilyName());

      authorRepository.save(author);
      return new AuthorSaveResponse(author.getId());

    } catch (Exception e) {
      throw new CustomServiceErrorException(
          new ValidationErrorResponse("1003", "Ошибка сохранения данных"));
    }
  }

  public BookSaveResponse saveBooks(BookSaveRequest book) {

    BookEntity bookEntity = new BookEntity();

    Optional<AuthorEntity> author = authorRepository.findById(book.getAuthor().getId());

    if (author.isEmpty()) {
      throw new CustomBadRequestException(
          new ValidationErrorResponse("1004", "Указанный автор не существует в таблице"));
    }

    try {
      log.info("Сохранение книги.");
      bookEntity.setBookTitle(book.getBookTitle()).setAuthor(author.get());

      bookRepository.save(bookEntity);

    } catch (Exception e) {
      throw new CustomServiceErrorException(
          new ValidationErrorResponse("1003", "Ошибка сохранения данных: ".concat(e.getMessage())));
    }

    return new BookSaveResponse(bookEntity.getId());
  }
}