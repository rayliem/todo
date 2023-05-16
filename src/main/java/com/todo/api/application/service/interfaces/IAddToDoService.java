package com.todo.api.application.service.interfaces;

import com.todo.api.application.requests.AddToDoRequest;
import com.todo.api.application.responses.AddToDoResponse;

public interface IAddToDoService {
    public AddToDoResponse addToDo(AddToDoRequest addToDoRequest);
}
