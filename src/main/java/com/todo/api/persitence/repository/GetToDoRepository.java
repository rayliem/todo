package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IGetToDoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GetToDoRepository implements IGetToDoRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ToDo getProfession(int id) {
        Transaction tx = null;
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        try {
            tx = session.beginTransaction();
            ToDo todo = session.get(ToDo.class, id);
            return todo;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<ToDo> getProfessions() {
        Transaction tx = null;
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        List<ToDo> todos;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ToDo> criteria = builder.createQuery(ToDo.class);
            Root<ToDo> ProfessionEntityRoot = criteria.from(ToDo.class);
            criteria.select(ProfessionEntityRoot);
            //do some work
            todos = session.createQuery(criteria).getResultList();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        return todos;
    }
}
