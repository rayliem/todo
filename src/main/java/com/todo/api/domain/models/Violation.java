package com.todo.api.domain.models;

import lombok.Getter;
import lombok.Setter;

public class Violation {
    @Getter@Setter
    private String fieldName;

    @Getter@Setter
    private String message;

    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
