package com.todo.api.persitence.repository;

import com.todo.api.domain.models.ToDo;
import com.todo.api.persitence.repository.Interface.IDeleteToDoRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteToDoRepository implements IDeleteToDoRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void deleteToDoFromTable(ToDo toDo) {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        //Merge object to current session, as the object comes from another session
        //session.merge(toDo);
        Transaction tx = session.beginTransaction();
        try {
            //Delete current record with new data.
            session.delete(toDo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
