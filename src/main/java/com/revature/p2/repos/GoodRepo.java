package com.revature.p2.repos;

import com.revature.p2.models.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodRepo implements CrudRepo<Good> {

    private SessionFactory sessionFactory;

    @Autowired
    public GoodRepo(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<Good> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Good", Good.class)
                .getResultList();
    }

    @Override
    public Good findById(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.get(Good.class, id);
    }

    @Override
    public Good save(Good newObj) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Good updatedObj) {

        Session session = sessionFactory.getCurrentSession();
        session.update(updatedObj);
        return true;
    }

    @Override
    public boolean deleteById(int id) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(id);
        return true;
    }
}