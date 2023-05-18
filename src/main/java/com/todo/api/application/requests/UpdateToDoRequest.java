package com.todo.api.application.requests;

import lombok.Getter;
import lombok.Setter;

public class UpdateToDoRequest {
    @Getter@Setter
    int toDoId;
    @Getter@Setter
    boolean status;

}
