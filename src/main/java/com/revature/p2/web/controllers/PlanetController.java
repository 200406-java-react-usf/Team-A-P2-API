package com.revature.p2.web.controllers;

import com.revature.p2.models.Planet;
import com.revature.p2.services.PlanetService;

import com.revature.p2.web.dtos.PlanetDTO;
import com.revature.p2.web.dtos.PlanetDTO;
import com.revature.p2.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping
    public List<PlanetDTO> getAllPlanets() {

        return planetService.getAllPlanets();
    }

    @GetMapping(value="{id}")
    public PlanetDTO getPlanetById(@PathVariable int id, HttpServletRequest req) {

        return planetService.getPlanetById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    @Secured(allowedRoles={"Admin"})
    public PlanetDTO registerNewPlanet(@RequestBody Planet newPlanet) {

        return planetService.register(newPlanet);
    }
}