package com.library.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "author")
@Accessors(chain = true)
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "second_name")
  private String secondName;

  @Column(name = "family_name")
  private String familyName;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<BookEntity> bookEntities;
}