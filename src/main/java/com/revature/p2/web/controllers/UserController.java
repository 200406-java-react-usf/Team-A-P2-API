package com.revature.p2.web.controllers;

import com.revature.p2.models.User;
import com.revature.p2.services.UserService;

import com.revature.p2.web.dtos.UserDTO;
import com.revature.p2.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        super();
        this.userService = service;
    }

    @GetMapping
//    @Secured(allowedRoles={"Admin"})
    public List<UserDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping(value="{id}")
    public UserDTO getUserById(@PathVariable int id, HttpServletRequest req) {
        
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public UserDTO registerNewUser(@RequestBody User newUser) {

        return userService.register(newUser);
    }

    @DeleteMapping
//    @Secured(allowedRoles = {"Admin"})
    public boolean deleteUser(@RequestBody User userToBeDeleted) {
        return userService.delete(userToBeDeleted.getId());
    }

    @PatchMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUser(@RequestBody User updatedUser) {
        return userService.update(updatedUser);
    }
}