package com.todo.api.application.requests;

import com.todo.api.domain.models.ToDo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class AddToDoRequest {
    @Getter@Setter
    private String title;
    @Getter@Setter
    private String body;

}
