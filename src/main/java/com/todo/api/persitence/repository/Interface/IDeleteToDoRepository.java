package com.todo.api.persitence.repository.Interface;

import com.todo.api.domain.models.ToDo;

public interface IDeleteToDoRepository {
    public void deleteToDoFromTable(ToDo toDo);
}
