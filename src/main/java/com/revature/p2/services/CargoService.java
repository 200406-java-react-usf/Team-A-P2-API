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

    /**
     * Gets all of the cargo in the database
     * @return a list of all cargo in the database
     */
    @Transactional(readOnly=true)
    public List<Cargo> getAllCargos() {
        return cargoRepo.findAll();
    }

    /**
     * Gets a cargo by its ID
     * @param id the id of the cargo you want to retrieve
     * @return the cargo with the provided ID
     */
    @Transactional(readOnly=true)
    public Cargo getCargoByID(int id) {
        Cargo retrievedGood = cargoRepo.findById(id);
        return retrievedGood;
    }

    /**
     * Gets a list of cargo objects with the provided user ID
     * @param id the user ID you want to get the cargo objects from
     * @return a list of cargo objects with the provided ID
     */
    @Transactional(readOnly=true)
    public List<Cargo> getCargoByUserID(int id) {
        List<Cargo> retrievedGood = (List<Cargo>) cargoRepo.findByUserId(id);
        return retrievedGood;
    }

    /**
     * Gets a list of cargo objects with the provided planet ID
     * @param id the ID of the planet
     * @return a list of cargo objects with the provided planet ID
     */
    @Transactional(readOnly=true)
    public List<Cargo> getCargoByPlanetID(int id) {
        List<Cargo> retrievedGood = (List<Cargo>) cargoRepo.findByPlanetId(id);
        return retrievedGood;
    }

    /**
     * Used to register a new cargo good
     * @param newGood the new good to be registered
     * @return the newly registered cargo
     */
    @Transactional
    public Cargo register(Cargo newGood) {
        return null;
    }

    /**
     * Used to update the info for a cargo good
     * @param updatedGood the updated info for the cargo good
     * @return the updated cargo good
     */
    @Transactional
    public Cargo updateCargo(Cargo updatedGood) {
        cargoRepo.update(updatedGood);
        return updatedGood;
    }

}