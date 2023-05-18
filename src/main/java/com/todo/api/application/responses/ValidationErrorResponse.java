package com.todo.api.application.responses;

import com.todo.api.domain.models.Violation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    @Getter@Setter
    private List<Violation> violations = new ArrayList<>();
}
