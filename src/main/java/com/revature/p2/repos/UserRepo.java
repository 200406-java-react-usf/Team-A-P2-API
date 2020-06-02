package com.revature.p2.repos;

import com.revature.p2.models.User;
import com.revature.p2.web.dtos.Creds;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements CrudRepo<User> {

    private SessionFactory sessionFactory;

    public User findUserByCreds(Creds creds) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u where u.username = :un and u.password = :pw", User.class)
                .setParameter("un", creds.getUsername())
                .setParameter("pw", creds.getPassword())
                .getSingleResult();

    }

    @Autowired
    public UserRepo(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<User> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User findById(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User save(User newObj) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(User updatedObj) {

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
