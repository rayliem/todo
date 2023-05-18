package com.todo.api.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ErrorDetails {
    @Getter@Setter
    private HttpStatus status;

    @Getter@Setter
    private String message;

    @Getter@Setter
    private String errorsDetails;
}
