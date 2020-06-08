package com.revature.p2.web.controllers;

import com.revature.p2.models.Cargo;
import com.revature.p2.models.PlanetGood;
import com.revature.p2.services.CargoService;

import com.revature.p2.web.dtos.CargoDTO;
import com.revature.p2.web.dtos.PlanetGoodDTO;
import com.revature.p2.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    private CargoService cargoService;

    @Autowired
    public CargoController(CargoService service) {
        super();
        this.cargoService = service;
    }

    @GetMapping
    public List<CargoDTO> getAllCargos() {

        return cargoService.getAllCargos();
    }

    @GetMapping(value="{id}")
    public CargoDTO getGoodById(@PathVariable int id, HttpServletRequest req) {

        return cargoService.getCargoById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public CargoDTO registerNewCargo(@RequestBody Cargo newCargo) {

        return cargoService.register(newCargo);
    }

    @GetMapping(value="/user/{id}")
    public List<CargoDTO> getCargoByUserId(@PathVariable int id) {
        return cargoService.getCargoListByUserId(id);
    }

    @GetMapping(value="/planet/{id}")
    public List<PlanetGoodDTO> getCargoListByPlanetId(@PathVariable int id) {
        return cargoService.getCargoListByPlanetId(id);
    }

    @GetMapping(value="/user/{uId}/good/{gId}")
    public List<CargoDTO> getCargoByUserIdAndGoodId(@PathVariable int uId, @PathVariable int gId) {
        return cargoService.getCargoByUserIdAndGoodId(uId, gId);
    }

    @PutMapping(value="/update/{uId}/{gId}/{cost}/{quantity}")
    public boolean updateCargo(@PathVariable int uId, @PathVariable int gId, @PathVariable int cost, @PathVariable int quantity) {
        return cargoService.updateCargo(uId, gId, cost, quantity);
    }


}