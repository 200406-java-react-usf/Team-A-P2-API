package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Cargo;
import com.revature.p2.models.PlanetGood;
import com.revature.p2.models.User;
import com.revature.p2.repos.CargoRepo;
import com.revature.p2.repos.UserRepo;
import com.revature.p2.web.dtos.CargoDTO;
import com.revature.p2.web.dtos.PlanetGoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CargoService {

    private CargoRepo cargoRepo;
    private UserRepo userRepo;

    @Autowired
    public CargoService(CargoRepo repo, UserRepo userRepo) {
        super();
        this.cargoRepo = repo;
        this.userRepo = userRepo;
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

    @Transactional
    public List<CargoDTO> getCargoListByUserId(int id) {
        return cargoRepo.findByUserId(id)
                .stream()
                .map(CargoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PlanetGoodDTO> getCargoListByPlanetId(int id) {
        return cargoRepo.findByPlanetId(id)
                .stream()
                .map(PlanetGoodDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public CargoDTO getCargoByUserIdAndGoodId(int uId, int gId) {
        return new CargoDTO( cargoRepo.findByUserIdAndGoodId(uId, gId) );
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
     * will update cargo
     * @param uId user id
     * @param gId good id
     * @param cost cost
     * @param quantity quantity
     * @return true if it works
     */
    @Transactional
    public boolean updateCargo(int uId, int gId, int cost, int quantity) {

        User u = userRepo.findById(uId);
        Cargo c = new Cargo(gId, uId, cost, quantity);
        CargoDTO b = getCargoByUserIdAndGoodId(uId, gId);
        c.setCostOfGoods(cost+b.getCostOfGoods());
        c.setQuantity(quantity+b.getQuantity());
        cargoRepo.update(c);
        u.setCurrency(u.getCurrency()-cost);
        u.setCargoSpace(u.getCargoSpace()-quantity);
        userRepo.update(u);
        return true;
    }

}