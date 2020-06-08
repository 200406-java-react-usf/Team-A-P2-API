
package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.exceptions.ResourcePersistenceException;
import com.revature.p2.models.Cargo;
import com.revature.p2.models.Good;
import com.revature.p2.models.UserRole;
import com.revature.p2.repos.GoodRepo;
import com.revature.p2.web.dtos.GoodDTO;
import com.revature.p2.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodService {

    private GoodRepo goodRepo;

    @Autowired
    public GoodService(GoodRepo repo) {
        super();
        this.goodRepo = repo;
    }

    /**
     * Gets all of the goods in the database
     * @return a list of all goods in the database
     */
    @Transactional(readOnly = true)
    public List<GoodDTO> getAllGoods() {
        return goodRepo.findAll()
                .stream()
                .map(GoodDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets a good by its ID
     * @param id the id of the good you want to retrieve
     * @return the good with the provided ID
     */
    @Transactional(readOnly = true)
    public GoodDTO getGoodById(int id) {

        if (id <= 0) {
            throw new BadRequestException();
        }

        Good retrievedGood = goodRepo.findById(id);

        if (retrievedGood == null) {
            throw new ResourceNotFoundException();
        }

        return new GoodDTO(retrievedGood);
    }

    /**
     * Used to register a new good
     * @param newGood good object wanting to be registered
     * @return the newly registered good
     */
    @Transactional
    public GoodDTO register(Good newGood) {

        if (newGood == null || newGood.getId() == 0 || newGood.getPrice() == 0 ||
                newGood.getDescription().trim().equals("") || newGood.getName().trim().equals("")) {
            throw new BadRequestException("Oh no! You provided bad data.");
        }

        if (!checkGoodAvailability(newGood)) {
            throw new ResourcePersistenceException("That good is already in the system.");
        }

        return new GoodDTO(goodRepo.save(newGood));
    }

    private boolean checkGoodAvailability(Good checkedGood) {
        return goodRepo.findByGoodName(checkedGood) == null;
    }

    @Transactional
    public GoodDTO updateGood(Good updatedGood) {

        goodRepo.update(updatedGood);
        return new GoodDTO(updatedGood);
    }

}