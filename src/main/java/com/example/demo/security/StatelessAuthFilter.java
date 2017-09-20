package com.example.demo.security;

import com.example.demo.service.TokenAuthService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class StatelessAuthFilter extends GenericFilterBean {

    private final TokenAuthService tokenAuthService;

    @Autowired
    public StatelessAuthFilter(@NonNull TokenAuthService tokenAuthService) {
        this.tokenAuthService = tokenAuthService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(tokenAuthService.getAuthentication((HttpServletRequest)servletRequest).orElse(null));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
