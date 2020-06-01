package com.revature.p2.web.controllers;

import com.revature.p2.models.Good;
import com.revature.p2.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Good> getAllGoods() {

        return goodService.getAllGoods();
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Good registerNewGood(@RequestBody Good newGood) {

        return goodService.register(newGood);
    }

}