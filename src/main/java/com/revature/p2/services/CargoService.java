package com.revature.p2.services;

import com.revature.p2.models.Cargo;
import com.revature.p2.repos.CargoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CargoService {

    private CargoRepo cargoRepo;

    @Autowired
    public CargoService(CargoRepo repo) {
        super();
        this.cargoRepo = repo;
    }

    @Transactional(readOnly=true)
    public List<Cargo> getAllCargos() {
        return cargoRepo.findAll();
    }

    @Transactional(readOnly=true)
    public Cargo getCargoByID(int id) {
        Cargo retrievedGood = cargoRepo.findById(id);
        return retrievedGood;
    }

    @Transactional(readOnly=true)
    public List<Cargo> getCargoByUserID(int id) {
        List<Cargo> retrievedGood = (List<Cargo>) cargoRepo.findByUserId(id);
        return retrievedGood;
    }
    @Transactional
    public Cargo register(Cargo newGood) {
        return null;
    }

}