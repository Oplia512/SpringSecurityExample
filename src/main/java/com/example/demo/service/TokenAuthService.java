package com.example.demo.service;

import com.example.demo.security.UserAthentication;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class TokenAuthService {

    private static final String AUTH_HEADER_TOKEN = "X-Auth-Token";

    @Autowired
    private UserService userService;
    @Autowired
    private TokenHandler tokenHandler;

    public Optional<Authentication> getAuthentication(@NonNull HttpServletRequest request) {

        return Optional
                .ofNullable(request.getHeader(AUTH_HEADER_TOKEN))
                .flatMap(tokenHandler::extractUserId)
                .flatMap(userService::findById)
                .map(UserAthentication::new);
    }
}

