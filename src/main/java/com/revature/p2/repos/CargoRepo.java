package com.revature.p2.repos;

import com.revature.p2.models.Cargo;
import com.revature.p2.models.Good;
import com.revature.p2.models.PlanetGood;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.util.List;


@Repository
public class CargoRepo implements CrudRepo<Cargo> {

    private SessionFactory sessionFactory;

    @Autowired
    public CargoRepo(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<Cargo> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo", Cargo.class)
                .getResultList();
    }

    @Override
    public Cargo findById(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo c where c.id = :id", Cargo.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    public List<Cargo> findByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo where user_id = :id", Cargo.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<PlanetGood> findByPlanetId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Planet_Goods where planet_id = :id", PlanetGood.class)
                .setParameter("id", id)
                .getResultList();
    }

    public Cargo findByUserIdAndGoodId(int uId, int gId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo where user_id = :uId and good_id = :gId", Cargo.class)
                .setParameter("uId", uId)
                .setParameter("gId", gId)
                .uniqueResult();
    }



    @Override
    public Cargo save(Cargo newObj) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }
    @Override
    public boolean update(Cargo updatedCargo) {
        Session session = sessionFactory.getCurrentSession();
        Cargo updateTarget = findByUserIdAndGoodId(updatedCargo.getUserId(), updatedCargo.getId());
        updateTarget.setQuantity(updatedCargo.getQuantity());
        updateTarget.setCostOfGoods(updatedCargo.getCostOfGoods());
        return true;
    }


    @Override
    public boolean deleteById(int id) {

        //WIP
        return false;
    }
}

