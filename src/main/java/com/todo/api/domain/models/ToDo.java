package com.todo.api.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    @Getter@Setter
    private int todoId;

    @Column(length = 30,nullable = false)
    @Getter@Setter
    private String title;

    @Column(length = 250,nullable = false)
    @Getter@Setter
    private String body;

    @Getter@Setter
    private String createdOn;

    @Getter@Setter
    private String updatedOn;

    @Getter@Setter
    private Boolean isDone;


}
