package com.todo.api.application.ExceptionHandlers.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
    public ItemNotFoundException(String message, Throwable cause) {
        super(message);
    }
}
