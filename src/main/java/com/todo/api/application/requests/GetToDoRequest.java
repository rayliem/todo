package com.todo.api.application.requests;

public class GetToDoRequest {
    private int todoId;
    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }
}
