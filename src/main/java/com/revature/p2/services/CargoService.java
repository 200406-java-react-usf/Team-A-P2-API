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

    /**
     * Gets all of the cargo in the database
     * @return a list of all cargo in the database
     */
    @Transactional(readOnly = true)
    public List<CargoDTO> getAllCargos() {
        return cargoRepo.findAll()
                .stream()
                .map(CargoDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets a cargo by its ID
     * @param id the id of the cargo you want to retrieve
     * @return the cargo with the provided ID
     */
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

    /**
     * Used to register a new cargo
     * @param newCargo the new cargo to be registered
     * @return the newly registered cargo
     */
    @Transactional
    public CargoDTO register(Cargo newCargo) {

        //TODO: Validation

        return new CargoDTO(cargoRepo.save(newCargo));

    }

    /**
     * Used to update the info for a cargo
     * @param updatedCargo the updated info for the cargo
     * @return the updated cargo
     */
    @Transactional
    public Cargo updateCargo(Cargo updatedCargo) {
        cargoRepo.update(updatedCargo);
        return updatedCargo;
    }

}