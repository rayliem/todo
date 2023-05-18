package com.todo.api.application.responses;

import com.todo.api.domain.models.ToDo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetToDoResponse {
    @Getter@Setter
    private List<ToDo> todos;
}
