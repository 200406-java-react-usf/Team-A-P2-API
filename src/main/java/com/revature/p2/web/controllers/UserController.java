package com.revature.p2.web.controllers;

import com.revature.p2.models.User;
import com.revature.p2.services.UserService;
import com.revature.p2.web.dtos.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        super();
        this.userService = service;
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public User registerNewUser(@RequestBody User newUser) {

        return userService.register(newUser);
    }

}