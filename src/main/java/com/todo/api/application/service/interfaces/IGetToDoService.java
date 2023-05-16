package com.todo.api.application.service.interfaces;

import com.todo.api.application.requests.GetToDoRequest;
import com.todo.api.application.responses.GetToDoResponse;

public interface IGetToDoService {
    public GetToDoResponse getToDoS();
    public GetToDoResponse getToDo(GetToDoRequest getToDoRequest);
}
