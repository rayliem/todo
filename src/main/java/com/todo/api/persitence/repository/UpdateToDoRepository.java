package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IUpdateToDoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UpdateToDoRepository implements IUpdateToDoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public ToDo updateToDo(ToDo toDo) {
        int recordId = toDo.getTodoId();
        ToDo updatedToDo = null;
        // merge will return the managed instance
        entityManager.merge(toDo);
        // fetch the updated entity
        updatedToDo = entityManager.find(ToDo.class, recordId);
        return updatedToDo;
    }
}
