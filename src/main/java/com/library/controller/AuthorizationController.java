package com.library.controller;

import com.library.api.AuthorizationV1;
import com.library.api.model.user.AuthRequest;
import com.library.api.model.user.AuthResponse;
import com.library.service.JwtService;
import com.library.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorizationController implements AuthorizationV1 {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(), request.getPassword())
        );

        if (authentication.isAuthenticated()) {
            log.info("Try to generate token");

            return new AuthResponse(jwtService.generateToken(request.getLogin()));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}