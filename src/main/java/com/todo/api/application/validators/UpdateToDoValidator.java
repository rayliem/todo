package com.todo.api.application.validators;

import com.todo.api.application.requests.AddToDoRequest;
import com.todo.api.application.requests.UpdateToDoRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UpdateToDoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UpdateToDoRequest.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        if (((UpdateToDoRequest) target).getToDoId() < 1) {
            errors.rejectValue("toDoId", "toDoId must be a valid id");
        }

    }
}
