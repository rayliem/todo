package com.todo.api.application.service;

import com.todo.api.application.ExceptionHandlers.Exceptions.ItemNotFoundException;
import com.todo.api.application.helpers.ConvertErrorsToStringHelper;
import com.todo.api.application.requests.AddToDoRequest;
import com.todo.api.application.requests.UpdateToDoRequest;
import com.todo.api.application.responses.UpdateToDoResponse;
import com.todo.api.application.service.interfaces.IUpdateToDoService;
import com.todo.api.application.validators.ToDoValidator;
import com.todo.api.application.validators.UpdateToDoValidator;
import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IGetToDoRepository;
import com.todo.api.persitence.repository.Interface.IUpdateToDoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
@Service
public class UpdateToDoService implements IUpdateToDoService {
    @Autowired
    public IUpdateToDoRepository updateToDoRepository;
    @Autowired
    public IGetToDoRepository getToDoRepository;
    @Override
    public UpdateToDoResponse updateToDo(UpdateToDoRequest updateToDoRequest) throws ValidationException{
        Errors result = new BeanPropertyBindingResult(updateToDoRequest, "updateToDoRequest");
        var updateToDoValidator  = new UpdateToDoValidator();
        updateToDoValidator.validate(updateToDoRequest,result);
        if (result.hasErrors()){
            String errors = ConvertErrorsToStringHelper.ConvertErrorsToString(result);
            throw new ValidationException(errors);
        }

        // Get the item that has to be updated
        var item = getToDoRepository.getProfession(updateToDoRequest.getToDoId());
        if(item == null){
            //Throw not found exception
            throw new ItemNotFoundException("Item not found");
        }

        //Update the item
        item.setUpdatedOn(new java.util.Date().toString());
        item.setIsDone(updateToDoRequest.isStatus());

        var addToDoResult = updateToDoRepository.updateToDo(item);
        var updatedResponse = new UpdateToDoResponse();
        updatedResponse.setToDo(addToDoResult);
        return updatedResponse;
    }
}
