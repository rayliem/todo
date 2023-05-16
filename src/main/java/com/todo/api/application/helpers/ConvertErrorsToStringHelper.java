package com.todo.api.application.helpers;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ConvertErrorsToStringHelper {
    public static String ConvertErrorsToString(Errors errors){
        var listOfErrors=errors.getAllErrors();
        StringBuilder errorsToString = new StringBuilder(250);
        for (ObjectError error: listOfErrors
        ) {
            errorsToString.append(error.toString());
        }
        return errorsToString.toString();
    }
}
