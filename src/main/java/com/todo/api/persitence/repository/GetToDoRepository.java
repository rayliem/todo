package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IGetToDoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GetToDoRepository implements IGetToDoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public ToDo getProfession(int id) {
        return entityManager.find(ToDo.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ToDo> getProfessions() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ToDo> criteria = builder.createQuery(ToDo.class);
        Root<ToDo> ProfessionEntityRoot = criteria.from(ToDo.class);
        criteria.select(ProfessionEntityRoot);
        return entityManager.createQuery(criteria).getResultList();
    }
}
