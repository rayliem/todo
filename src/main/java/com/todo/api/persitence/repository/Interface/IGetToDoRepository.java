package com.todo.api.persitence.repository.Interface;

import com.todo.api.domain.models.ToDo;

import java.util.List;

public interface IGetToDoRepository {

    public ToDo getProfession(int id);
    public List<ToDo> getProfessions();
}
