package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Good;
import com.revature.p2.repos.GoodRepo;
import com.revature.p2.web.dtos.GoodDTO;
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

    @Transactional(readOnly = true)
    public List<GoodDTO> getAllGoods() {
        return goodRepo.findAll()
                .stream()
                .map(GoodDTO::new)
                .collect(Collectors.toList());
    }

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

    @Transactional
    public GoodDTO register(Good newGood) {

        //TODO: Validation

        return new GoodDTO(goodRepo.save(newGood));

    }

}