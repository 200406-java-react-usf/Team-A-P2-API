package com.revature.p2.repos;

import com.revature.p2.models.Cargo;
import com.revature.p2.models.Good;
import com.revature.p2.models.PlanetGood;
import com.revature.p2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return session.get(Cargo.class, id);
    }

    public List<Cargo> findByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo where user_id = :id", Cargo.class)
                .setParameter("id", id)
                .getResultList();
    }

    /**findByUserAndGoodId method to look
     * if a user has a good in their cargo
     * and will return null if not found.*/
    public Cargo findByUserAndGoodId(Cargo checkedCargo) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo c where c.userId = :userId and c.id = :id", Cargo.class)
                .setParameter("id", checkedCargo.getId())
                .setParameter("userId", checkedCargo.getUserId())
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
        Cargo updateTarget = findByUserAndGoodId(updatedCargo);
        updateTarget.setQuantity(updatedCargo.getQuantity());
        updateTarget.setCostOfGoods(updatedCargo.getCostOfGoods());
        return true;
    }

    @Override
    public boolean deleteById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Cargo deleteTarget = session.get(Cargo.class, id);
        session.delete(deleteTarget);
        return true;
    }
}

