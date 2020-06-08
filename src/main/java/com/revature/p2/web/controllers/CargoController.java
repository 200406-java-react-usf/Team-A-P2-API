package com.revature.p2.web.controllers;

import com.revature.p2.models.Cargo;
import com.revature.p2.services.CargoService;

import com.revature.p2.web.dtos.CargoDTO;
import com.revature.p2.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private CargoService cargoService;

    @Autowired
    public CargoController(CargoService service) {
        super();
        this.cargoService = service;
    }

    @GetMapping
    @Secured(allowedRoles={"Admin"})
    public List<CargoDTO> getAllCargos() {

        return cargoService.getAllCargos();
    }

    @GetMapping(value="{id}")
    public List<CargoDTO> getCargoByUserId(@PathVariable int id, HttpServletRequest req) {

        return cargoService.getAllUserCargo(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public CargoDTO registerNewCargo(@RequestBody Cargo newCargo) {

        return cargoService.register(newCargo);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean updateCargo(@RequestBody Cargo updatedCargo) {

        return cargoService.updateCargo(updatedCargo);
    }
}