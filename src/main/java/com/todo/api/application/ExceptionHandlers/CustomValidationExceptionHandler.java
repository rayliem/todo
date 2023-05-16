package com.todo.api.application.ExceptionHandlers;

import com.todo.api.application.ExceptionHandlers.Exceptions.ItemNotFoundException;
import com.todo.api.domain.models.ErrorDetails;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomValidationExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> handleConstraintViolationException(ValidationException exception) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setMessage("Validation Failed");
        errorDetails.setErrorsDetails(exception.getMessage());
        return ResponseEntity.badRequest().body(errorDetails);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(ItemNotFoundException exception) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.NOT_FOUND);
        errorDetails.setMessage("Item you requested was not found");
        errorDetails.setErrorsDetails(exception.getMessage());
        return ResponseEntity.notFound().build();
    }
}
