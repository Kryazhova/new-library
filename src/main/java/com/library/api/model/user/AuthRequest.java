package com.library.api.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthRequest {

    @NotNull(message = "Не передан обязательный параметр: password или login")
    @Length(min = 5, max = 50, message = "Некорректная длина поля")
    private String login;

    @NotNull(message = "Не передан обязательный параметр: password или login")
    @Length(min = 5, max = 50, message = "Некорректная длина поля")
    private String password;
}