package com.library.db.repository;

import com.library.db.entity.BookEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

  List<BookEntity> findAllByAuthor_Id(Long authorId);

  Optional<BookEntity> findById(Long bookId);
}
