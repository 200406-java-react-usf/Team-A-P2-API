package com.revature.p2.services;

import com.revature.p2.models.Good;
import com.revature.p2.repos.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodService {

    private GoodRepo goodRepo;

    @Autowired
    public GoodService(GoodRepo repo) {
        super();
        this.goodRepo = repo;
    }

    /**
     * Gets all of the goods in the database
     * @return a list of all goods in the database
     */
    @Transactional(readOnly=true)
    public List<Good> getAllGoods() {
        return goodRepo.findAll();
    }

    /**
     * Gets a good by its ID
     * @param id the id of the good you want to retrieve
     * @return the good with the provided ID
     */
    @Transactional(readOnly=true)
    public Good getGoodByID(int id) {
        Good retrievedGood = goodRepo.findById(id);
        return retrievedGood;
    }

    /**
     * Used to register a new good
     * @param newGood good object wanting to be registered
     * @return the newly registered good
     */
    @Transactional
    public Good register(Good newGood) {
        return goodRepo.save(newGood);
    }

}