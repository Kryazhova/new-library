package com.library.db.repository;

import com.library.db.entity.AuthorEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

  Optional<AuthorEntity> findById(Long authorId);

  Optional<AuthorEntity> findByFirstNameAndFamilyName(String firstName, String familyName);
}
