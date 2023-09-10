package com.library.api;

import com.library.api.model.user.AuthRequest;
import com.library.api.model.user.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RequestMapping("auth")
public interface AuthorizationV1 {

    @GetMapping(value = "/login", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody @Valid AuthRequest request);
}