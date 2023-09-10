package com.library.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;


@Entity
@Data
@Table(name = "users")
@Accessors(chain = true)
public class UserInfoEntity {

    @Id
    @Column(name = "id")
    private long id;

    private String login;

    private String password;

    private String role;
}