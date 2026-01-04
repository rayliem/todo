package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IAddToDoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AddToDoRepository implements IAddToDoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public ToDo addToDo(ToDo toDo) {
        entityManager.persist(toDo);
        return toDo;
    }
}
