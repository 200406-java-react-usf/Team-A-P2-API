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

    @Transactional(readOnly=true)
    public List<Planet> getAllPlanets() {
        return planetRepo.findAll();
    }

    @Transactional(readOnly=true)
    public Planet getPlanetByID(int id) {
        Planet retrievedPlanet = planetRepo.findById(id);
        return retrievedPlanet;
    }


    @Transactional
    public Planet register(Planet newPlanet) {
        return planetRepo.save(newPlanet);
    }

}