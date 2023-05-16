package com.todo.api.application.validators;

import com.todo.api.application.requests.AddToDoRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

public class ToDoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AddToDoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (((AddToDoRequest) target).getTitle() ==null ||
                ((AddToDoRequest) target).getTitle().isBlank()) {
            errors.rejectValue("title", "title must be provided");
        }
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "professionRequest.Profession", "professionRequest.Profession.required");
        if (((AddToDoRequest) target).getBody() ==null ||
                ((AddToDoRequest) target).getBody().isBlank()) {
            errors.rejectValue("body", "professionDescription must be provided");
        }

        if (((AddToDoRequest) target).getTitle().length() >= 30 ) {
            errors.rejectValue("title", "professionDescription must be 75 chars or lower");
        }

        if (((AddToDoRequest) target).getBody().length() >= 250 ){
            errors.rejectValue("body", "professionDescription must be 75 chars or lower");
        }
    }
}
