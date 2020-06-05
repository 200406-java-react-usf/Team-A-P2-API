package com.revature.p2.services;

import com.revature.p2.exceptions.AuthenticationException;
import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourcePersistenceException;
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

    /**
     * NEED ADMIN ROLE TO ACCESS
     * Will return all of the users in the database
     * @return a List of all users that exist in the database
     */
    @Transactional(readOnly=true)
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll()
                        .stream()
                        .map(UserDTO::new)
                        .collect(Collectors.toList());
    }

    /**
     * Will get a single user by their ID
     * @param id the ID of the user you want to find
     * @return the user with provided ID
     */
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

    /**
     * Used for login purposes. Will validate that user is logging in with correct username & password
     * @param creds a username & password
     * @return the newly logged in user
     */
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


    /**
     * Will register a new user in the database, checking to see if the username exists before persisting
     * @param newUser user object to be registered (username & password req)
     * @return the newly registered user
     */
    @Transactional
    public UserDTO register(User newUser) {

        //TODO: WIP -- THROWING ERROR IF USERNAME IS AVAILABLE THAT ISN'T BEING CAUGHT CORRECTLY

        if (newUser == null || newUser.getUsername() == null || newUser.getPassword() == null ||
                newUser.getUsername().trim().equals("") || newUser.getPassword().trim().equals("")) {
            throw new BadRequestException("Oh no! You did not provide a valid username or password.");
        }

        // will be true if username is available, false if already taken
        boolean isUsernameAvailable = checkUsername(newUser.getUsername());

        if (!isUsernameAvailable) {
            throw new ResourcePersistenceException("That username is already taken.");
        }

        newUser.setRole(UserRole.USER);
        return new UserDTO(userRepo.save(newUser));

    }

    /**
     * Will check to see if the username is already in the database
     * @param username
     * @return true if no user is found with that username; false if user already exists with that username
     */
    private boolean checkUsername(String username) {
        try{
            userRepo.findUserByUsername(username);
        } catch(NoResultException e) {
            return true;
        }
        return false;
    }
}