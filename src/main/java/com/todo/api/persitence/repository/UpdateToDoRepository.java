package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IUpdateToDoRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateToDoRepository implements IUpdateToDoRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ToDo updateToDo(ToDo toDo) {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction tx = session.beginTransaction();
        int recordId = toDo.getTodoId();
        ToDo updatedToDo =null;
        try {
            //Update current record with new data.
            session.update(toDo);
            //Get freshly updated record from database to confirm change.
            updatedToDo = session.get(ToDo.class, recordId);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            //throw e;
        }
        return updatedToDo;
    }
}
