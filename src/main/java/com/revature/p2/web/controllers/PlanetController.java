package com.revature.p2.web.controllers;

import com.revature.p2.models.Planet;
import com.revature.p2.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService service) {
        super();
        this.planetService = service;
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Planet> getAllPlanets() {

        return planetService.getAllPlanets();
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Planet registerNewPlanet(@RequestBody Planet newPlanet) {

        return planetService.register(newPlanet);
    }

}