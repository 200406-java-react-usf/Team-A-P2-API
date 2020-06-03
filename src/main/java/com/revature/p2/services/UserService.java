package com.revature.p2.services;

import com.revature.p2.exceptions.AuthenticationException;
import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.models.Good;
import com.revature.p2.models.Planet;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.User;
import com.revature.p2.models.UserRole;
import com.revature.p2.repos.UserRepo;
import com.revature.p2.web.dtos.Creds;
import com.revature.p2.web.dtos.Principal;
import com.revature.p2.web.dtos.UserDTO;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo repo) {
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly=true)
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll()
                        .stream()
                        .map(UserDTO::new)
                        .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO getUserById(int id) {

        if (id <= 0) {
            throw new BadRequestException();
        }

        User retrievedUser = userRepo.findById(id);

        if (retrievedUser == null) {
            throw new ResourceNotFoundException();
        }

        return new UserDTO(retrievedUser);
    }

    @Transactional(readOnly=true)
    public Principal authenticate(Creds creds) {

        if (creds == null || creds.getUsername() == null || creds.getPassword() == null
            || creds.getUsername().trim().equals("") || creds.getPassword().trim().equals(""))
        {
            throw new BadRequestException();
        }

        User retrievedUser;

        try {
            retrievedUser = userRepo.findUserByCreds(creds.getUsername(), creds.getPassword());
        } catch (NoResultException e) {
            throw new AuthenticationException("Authentication failed!", e);
        }

        return new Principal(retrievedUser);

    }


    @Transactional
    public UserDTO register(User newUser) {

        //TODO: Validation

        newUser.setRole(UserRole.USER);
        return new UserDTO(userRepo.save(newUser));

    }
}