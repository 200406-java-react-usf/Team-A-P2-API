package com.revature.p2.web.controllers;

import com.revature.p2.services.UserService;
import com.revature.p2.web.dtos.Creds;
import com.revature.p2.web.dtos.Principal;
import com.revature.p2.web.security.JwtConfig;
import com.revature.p2.web.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService service) {
        this.userService = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Principal unauthenticate(){
        return null;
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Principal authenticate(@RequestBody Creds creds, HttpServletResponse resp) {
        Principal payload = userService.authenticate(creds);
        resp.setHeader(JwtConfig.HEADER, TokenGenerator.createJwt(payload));
        return payload;
    }

}