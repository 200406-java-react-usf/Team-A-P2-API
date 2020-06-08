package com.revature.p2.services;

import com.revature.p2.exceptions.*;
import com.revature.p2.models.Planet;
import com.revature.p2.models.User;
import com.revature.p2.models.UserRole;
import com.revature.p2.repos.UserRepo;
import com.revature.p2.web.dtos.Creds;
import com.revature.p2.web.dtos.Principal;
import com.revature.p2.web.dtos.UserDTO;

import com.sun.istack.NotNull;
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
        try {
            return userRepo.findAll()
                    .stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList());
        } catch(Exception e) {
            throw new ResourceNotFoundException();
        }

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
    public UserDTO authenticate(Creds creds) {

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

        return new UserDTO(retrievedUser);

    }

    /**
     * Will register a new user in the database, checking to see if the username exists before persisting
     * @param newUser user object to be registered (username & password req)
     * @return the newly registered user
     */
    @Transactional
    public UserDTO register(User newUser) {

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
        newUser.setLocationId(1);
        newUser.setCargoSpace(1000);
        newUser.setCurrency(1000);
        return new UserDTO(userRepo.save(newUser));

    }

    /**
     * Used to update a users username and/or password (only things that are updatable as of now)
     * @param updatedUser the username & password as a User object
     * @return true if update was complete
     */
    @Transactional
    public boolean update(User updatedUser) {

        if (updatedUser == null) {
            throw new BadRequestException();
        }

        try {
            userRepo.update(updatedUser);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
        return true;
    }

    /**
     * Will delete a user from the database
     * Admin access required for this action (for now)
     * @param userId the id of the user you want to delete
     * @return true if user was deleted, false if user was not
     */
    @Transactional
    public boolean delete(@NotNull int userId) {
        try {
            return userRepo.deleteById(userId);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }

    }

    /**
     * Will check to see if the username is already in the database
     * @param username the username you are checking
     * @return true if no user is found with that username; false if user already exists with that username
     */
    private boolean checkUsername(String username) {
        return userRepo.findUserByUsername(username) == null;
    }
}