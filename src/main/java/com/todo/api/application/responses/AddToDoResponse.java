package com.todo.api.application.responses;

import com.todo.api.domain.models.ToDo;
import lombok.Getter;
import lombok.Setter;

public class AddToDoResponse {
    @Getter@Setter
    private ToDo toDo;
}
