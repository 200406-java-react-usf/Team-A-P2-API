package com.revature.p2.services;

import com.revature.p2.models.Good;
import com.revature.p2.models.Planet;
import com.revature.p2.repos.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetService {

    private PlanetRepo planetRepo;

    @Autowired
    public PlanetService(PlanetRepo repo) {
        super();
        this.planetRepo = repo;
    }

    /**
     * Gets all of the planets in the database
     * @return a list of all planets in the database
     */
    @Transactional(readOnly=true)
    public List<Planet> getAllPlanets() {
        return planetRepo.findAll();
    }

    /**
     * Gets a planet by its ID
     * @param id the id of the planet you want to retrieve
     * @return the planet with the provided ID
     */
    @Transactional(readOnly=true)
    public Planet getPlanetByID(int id) {
        Planet retrievedPlanet = planetRepo.findById(id);
        return retrievedPlanet;
    }

    /**
     * Used to register a new planet
     * @param newPlanet planet object wanting to be registered
     * @return the newly registered planet
     */
    @Transactional
    public Planet register(Planet newPlanet) {
        return planetRepo.save(newPlanet);
    }

}