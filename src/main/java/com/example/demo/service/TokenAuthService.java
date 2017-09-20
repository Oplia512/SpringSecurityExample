package com.example.demo.service;

import lombok.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class TokenAuthService {
    public Optional<Authentication> getAuthentication(@NonNull HttpServletRequest servletRequest) {
        return Optional.empty();
    }
}

