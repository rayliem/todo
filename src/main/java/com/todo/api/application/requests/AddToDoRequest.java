package com.todo.api.application.requests;

import com.todo.api.domain.models.ToDo;

import java.util.Date;

public class AddToDoRequest {
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
