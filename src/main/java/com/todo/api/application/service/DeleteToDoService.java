package com.todo.api.application.service;

import com.todo.api.application.ExceptionHandlers.Exceptions.ItemNotFoundException;
import com.todo.api.application.service.interfaces.IDeleteToDoService;
import com.todo.api.persitence.repository.Interface.IDeleteToDoRepository;
import com.todo.api.persitence.repository.Interface.IGetToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteToDoService implements IDeleteToDoService {
    @Autowired
    private IGetToDoRepository getToDoRepository;
    @Autowired
    private IDeleteToDoRepository deleteToDoRepository;
    @Override
    public void deleteToDo(int toDoId) {
        var item = getToDoRepository.getProfession(toDoId);
        if(item == null){
            //Throw not found exception
            throw new ItemNotFoundException("Item not found");
        }

        deleteToDoRepository.deleteToDoFromTable(item);
    }
}
