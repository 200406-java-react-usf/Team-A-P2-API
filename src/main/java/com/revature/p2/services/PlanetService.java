package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Planet;
import com.revature.p2.repos.PlanetRepo;
import com.revature.p2.web.dtos.PlanetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional(readOnly = true)
    public List<PlanetDTO> getAllPlanets() {
        return planetRepo.findAll()
                .stream()
                .map(PlanetDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets a planet by its ID
     * @param id the id of the planet you want to retrieve
     * @return the planet with the provided ID
     */
    @Transactional(readOnly = true)
    public PlanetDTO getPlanetById(int id) {

        if (id <= 0) {
            throw new BadRequestException();
        }

        Planet retrievedPlanet = planetRepo.findById(id);

        if (retrievedPlanet == null) {
            throw new ResourceNotFoundException();
        }

        return new PlanetDTO(retrievedPlanet);
    }

    /**
     * Used to register a new planet
     * @param newPlanet planet object wanting to be registered
     * @return the newly registered planet
     */
    @Transactional
    public PlanetDTO register(Planet newPlanet) {

        //TODO: Validation

        return new PlanetDTO(planetRepo.save(newPlanet));
    }
}