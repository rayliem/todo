package com.todo.api.application.service;

import com.todo.api.application.requests.GetToDoRequest;
import com.todo.api.application.responses.GetToDoResponse;
import com.todo.api.application.service.interfaces.IGetToDoService;
import com.todo.api.persitence.repository.Interface.IGetToDoRepository;
import com.todo.api.domain.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class GetToDoService implements IGetToDoService {
    @Autowired
    IGetToDoRepository getToDoRepository;
    @Override
    public GetToDoResponse getToDoS() {
        var toDos = getToDoRepository.getProfessions();
        GetToDoResponse getToDoResponse = new GetToDoResponse();
        getToDoResponse.setTodos(toDos);
        return getToDoResponse;
    }

    @Override
    public GetToDoResponse getToDo(GetToDoRequest getToDoRequest) {
        var toDo = getToDoRepository.getProfession(getToDoRequest.getTodoId());
        GetToDoResponse getToDoResponse = new GetToDoResponse();
        List<ToDo> toDos = new LinkedList<ToDo>();
        toDos.add(toDo);
        getToDoResponse.setTodos(toDos);
        return getToDoResponse;
    }
}
