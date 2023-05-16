package com.todo.api.application.service;

import com.todo.api.application.helpers.ConvertErrorsToStringHelper;
import com.todo.api.application.requests.AddToDoRequest;
import com.todo.api.application.responses.AddToDoResponse;
import com.todo.api.application.service.interfaces.IAddToDoService;
import com.todo.api.application.validators.ToDoValidator;
import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IAddToDoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Date;

@Service
public class AddToDoService implements IAddToDoService {
    @Autowired
    public IAddToDoRepository addToDoRepository;
    @Override
    public AddToDoResponse addToDo(AddToDoRequest addToDoRequest) throws ValidationException {
        Errors result = new BeanPropertyBindingResult(addToDoRequest, "addToDoRequest");
        var toDoValidator  = new ToDoValidator();
        toDoValidator.validate(addToDoRequest,result);
        if (result.hasErrors()){
            String errors = ConvertErrorsToStringHelper.ConvertErrorsToString(result);
            throw new ValidationException(errors);
        }
        ToDo newTodo = new ToDo();
        newTodo.setBody(addToDoRequest.getBody());
        newTodo.setDone(false);
        newTodo.setTitle(addToDoRequest.getTitle());
        newTodo.setCreatedOn(new java.util.Date().toString());
        var response = addToDoRepository.addToDo(newTodo);
        var addToDoResponse = new AddToDoResponse();
        addToDoResponse.setToDo(response);
        return addToDoResponse;
    }

}
