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

    @Transactional(readOnly=true)
    public List<Good> getAllGoods() {
        return goodRepo.findAll();
    }

    @Transactional
    public Good register(Good newGood) {
        return null;
    }

}