package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Good;
import com.revature.p2.models.Planet;
import com.revature.p2.models.User;
import com.revature.p2.repos.PlanetRepo;
import com.revature.p2.web.dtos.PlanetDTO;
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

    @Transactional(readOnly = true)
    public List<PlanetDTO> getAllPlanets() {
        return planetRepo.findAll()
                .stream()
                .map(PlanetDTO::new)
                .collect(Collectors.toList());
    }

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

    @Transactional
    public PlanetDTO register(Planet newPlanet) {

        //TODO: Validation

        return new PlanetDTO(planetRepo.save(newPlanet));
    }
}