package com.revature.p2.repos;

import com.revature.p2.models.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlanetRepo implements CrudRepo<Planet> {

    private SessionFactory sessionFactory;

    @Autowired
    public PlanetRepo(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<Planet> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Planet", Planet.class)
                .getResultList();
    }

    @Override
    public Planet findById(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.get(Planet.class, id);
    }

    @Override
    public Planet save(Planet newObj) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Planet updatedObj) {

        //WIP
        return false;
    }

    @Override
    public boolean deleteById(int id) {

        //WIP
        return false;
    }
}
