package com.revature.p2.repos;

import com.revature.p2.models.Good;
import com.revature.p2.models.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

    public Planet findByPlanetName(Planet checkedPlanet) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Planet p where p.planet_name = :name", Planet.class)
                .setParameter("name", checkedPlanet.getName())
                .uniqueResult();
    }

    @Override
    public Planet save(Planet newObj) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Planet updatedObj) {

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