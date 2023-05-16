package com.todo.api.domain.models;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private String errorsDetails;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorsDetails() {
        return errorsDetails;
    }

    public void setErrorsDetails(String errorsDetails) {
        this.errorsDetails = errorsDetails;
    }
}
