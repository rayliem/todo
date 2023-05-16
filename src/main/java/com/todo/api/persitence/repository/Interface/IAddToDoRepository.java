package com.todo.api.persitence.repository.Interface;

import com.todo.api.domain.models.ToDo;

import java.util.List;

public interface IAddToDoRepository {
    public ToDo addToDo(ToDo toDo);
}
