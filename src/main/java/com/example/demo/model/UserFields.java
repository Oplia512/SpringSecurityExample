package com.example.demo.model;

public enum UserFields {
    USER_NAME("username");

    private String field;

    UserFields(String field) {
        this.field = field;
    }

    public String field() {
        return field;
    }
}
