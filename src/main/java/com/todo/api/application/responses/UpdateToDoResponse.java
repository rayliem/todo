package com.todo.api.application.responses;

import com.todo.api.domain.models.ToDo;

public class UpdateToDoResponse {
    private ToDo toDo;
    public ToDo getToDo() {
        return toDo;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }
}
