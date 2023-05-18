package com.todo.api.application.responses;

import com.todo.api.domain.models.ToDo;
import lombok.Getter;
import lombok.Setter;

public class UpdateToDoResponse {
    @Getter@Setter
    private ToDo toDo;
}
