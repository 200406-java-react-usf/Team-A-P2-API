package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Cargo;
import com.revature.p2.repos.CargoRepo;
import com.revature.p2.web.dtos.CargoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CargoService {

    private CargoRepo cargoRepo;

    @Autowired
    public CargoService(CargoRepo repo) {
        super();
        this.cargoRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<CargoDTO> getAllCargos() {
        return cargoRepo.findAll()
                .stream()
                .map(CargoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CargoDTO getCargoById(int id) {

        if (id <= 0) {
            throw new BadRequestException();
        }

        Cargo retrievedCargo = cargoRepo.findById(id);

        if (retrievedCargo == null) {
            throw new ResourceNotFoundException();
        }

        return new CargoDTO(retrievedCargo);
    }

    @Transactional
    public CargoDTO register(Cargo newCargo) {

        //TODO: Validation

        return new CargoDTO(cargoRepo.save(newCargo));

    }

    @Transactional
    public Cargo updateCargo(Cargo updatedCargo) {
        cargoRepo.update(updatedCargo);
        return updatedCargo;
    }

}