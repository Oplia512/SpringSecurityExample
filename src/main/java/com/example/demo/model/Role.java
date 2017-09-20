package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    POWER_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
