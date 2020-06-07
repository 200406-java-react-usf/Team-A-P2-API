package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.exceptions.ResourcePersistenceException;
import com.revature.p2.models.Cargo;
import com.revature.p2.models.PlanetGood;
import com.revature.p2.repos.PlanetGoodRepo;
import com.revature.p2.web.dtos.CargoDTO;
import com.revature.p2.web.dtos.PlanetGoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetGoodService {

    private PlanetGoodRepo planetGoodRepo;

    @Autowired
    public PlanetGoodService(PlanetGoodRepo repo) {
        super();
        this.planetGoodRepo = repo;
    }

    /**
     * Gets all of the PlanetGoods in the database
     * @return a list of all cargo in the database
     */
    @Transactional(readOnly = true)
    public List<PlanetGoodDTO> getAllCargos() {
        return planetGoodRepo.findAll()
                .stream()
                .map(PlanetGoodDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets a cargo by its ID
     * @param id the id of the cargo you want to retrieve
     * @return the cargo with the provided ID
     */
    @Transactional(readOnly = true)
    public PlanetGoodDTO getGoodById(int id) {

        if (id <= 0) {
            throw new BadRequestException();
        }

        PlanetGood retrievedGood = planetGoodRepo.findById(id);

        if (retrievedGood == null) {
            throw new ResourceNotFoundException();
        }

        return new PlanetGoodDTO(retrievedGood);
    }

    /**
     * Used to register a new cargo
     * @param newGood the new cargo to be registered
     * @return the newly registered cargo
     */
    @Transactional
    public PlanetGoodDTO register(PlanetGood newGood) {

        if (newGood == null || newGood.getId() <= 0 || newGood.getPlanetId() <= 0||
                newGood.getPriceMod()  <= 0){
            throw new BadRequestException("Oh no! You provided bad data.");
        }

        return new PlanetGoodDTO(planetGoodRepo.save(newGood));

    }

    /**
     * Used to update the info for a cargo
     * @param updatedGood the updated info for the cargo
     * If the cargo does not exist it invokes the save method instead
     * @return the updated cargo
     */
    @Transactional
    public PlanetGood updatePlanetGood(PlanetGood updatedGood) {

        if (!checkAvailability(updatedGood)){
            planetGoodRepo.save(updatedGood);
        }else if (checkAvailability(updatedGood)){
            planetGoodRepo.update(updatedGood);
        }
        return updatedGood;
    }

    private boolean checkAvailability(PlanetGood updatedGood) {
        return planetGoodRepo.findByPlanetAndGoodId(updatedGood) == null;
    }

}