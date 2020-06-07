package com.revature.p2.repos;

import com.revature.p2.models.Cargo;
import com.revature.p2.models.Good;
import com.revature.p2.models.PlanetGood;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanetGoodRepo implements CrudRepo<PlanetGood> {

    private SessionFactory sessionFactory;

    @Autowired
    public PlanetGoodRepo(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<PlanetGood> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from planet_goods", PlanetGood.class)
                .getResultList();
    }

    @Override
    public PlanetGood findById(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.get(PlanetGood.class, id);
    }

    public List<PlanetGood> findByPlanetId(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from planet_goods where planet_id = :id")
                .setParameter("id", id)
                .getResultList();
        
    }

    @Override
    public PlanetGood save(PlanetGood newObj) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }
    @Override
    public boolean update(PlanetGood updatedPGood) {
        
        Session session = sessionFactory.getCurrentSession();
        PlanetGood updateTarget = session.get(PlanetGood.class, (updatedPGood.getPlanetId() & updatedPGood.getId()));
        updateTarget.setPriceMod(updatedPGood.getPriceMod());
        return true;
    }

    @Override
    public boolean deleteById(int id) {

        Session session = sessionFactory.getCurrentSession();
        PlanetGood deleteTarget = session.get(PlanetGood.class, id);
        session.delete(deleteTarget);
        
        return true;
    }
}