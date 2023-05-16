package com.todo.api.application.responses;

import com.todo.api.domain.models.ToDo;

import java.util.List;

public class GetToDoResponse {
    private List<ToDo> todos;

    public List<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }
}
