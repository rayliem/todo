package com.todo.api.application.service.interfaces;

import com.todo.api.application.requests.AddToDoRequest;
import com.todo.api.application.requests.UpdateToDoRequest;
import com.todo.api.application.responses.AddToDoResponse;
import com.todo.api.application.responses.UpdateToDoResponse;

public interface IUpdateToDoService {
    public UpdateToDoResponse updateToDo(UpdateToDoRequest updateToDoRequest);
}
