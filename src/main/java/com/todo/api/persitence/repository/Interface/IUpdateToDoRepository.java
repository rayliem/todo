package com.todo.api.persitence.repository.Interface;

import com.todo.api.domain.models.ToDo;

public interface IUpdateToDoRepository {
    public ToDo updateToDo(ToDo toDo);
}
