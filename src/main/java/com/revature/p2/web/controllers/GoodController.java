package com.revature.p2.web.controllers;

import com.revature.p2.models.Good;
import com.revature.p2.models.Good;
import com.revature.p2.services.GoodService;

import com.revature.p2.web.dtos.GoodDTO;
import com.revature.p2.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodController {

    private GoodService goodService;

    @Autowired
    public GoodController(GoodService service) {
        super();
        this.goodService = service;
    }

    @GetMapping
    @Secured(allowedRoles={"Admin"})
    public List<GoodDTO> getAllGoods() {

        return goodService.getAllGoods();
    }

    @GetMapping(value="{id}")
    public GoodDTO getGoodById(@PathVariable int id, HttpServletRequest req) {

        return goodService.getGoodById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public GoodDTO registerNewGood(@RequestBody Good newGood) {

        return goodService.register(newGood);
    }
}