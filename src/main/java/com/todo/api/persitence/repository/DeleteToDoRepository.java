package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IDeleteToDoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DeleteToDoRepository implements IDeleteToDoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteToDoFromTable(ToDo toDo) {
        // Ensure managed instance before removal
        ToDo managed = entityManager.contains(toDo) ? toDo : entityManager.merge(toDo);
        entityManager.remove(managed);
    }
}
