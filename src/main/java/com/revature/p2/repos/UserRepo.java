package com.revature.p2.repos;

import com.revature.p2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements CrudRepo<User> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepo(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    public User findUserByCreds(String username, String password) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u where u.username = :un and u.password = :pw", User.class)
                .setParameter("un", username)
                .setParameter("pw", password)
                .getSingleResult();

    }

    public User findUserByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u where u.username = :un", User.class)
                .setParameter("un", username)
                .uniqueResult();
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
        User userToBeDeleted = session.find(User.class, id);
        session.delete(userToBeDeleted);
        return true;
    }
}