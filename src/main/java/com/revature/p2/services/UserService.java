package com.revature.p2.services;

import com.revature.p2.exceptions.AuthenticationException;
import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.models.User;
import com.revature.p2.models.UserRole;
import com.revature.p2.repos.UserRepo;
import com.revature.p2.web.dtos.Creds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo repo) {
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly=true)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional(readOnly=true)
    public User authenticate(Creds creds) {

        if (creds == null || creds.getUsername() == null || creds.getPassword() == null
                || creds.getUsername().equals("") || creds.getPassword().equals(""))
        {
            throw new BadRequestException("Invalid credentials object provided!");
        }

        User retrievedUser = userRepo.findUserByCreds(creds);

        if (retrievedUser == null) {
            throw new AuthenticationException();
        }

        return retrievedUser;

    }

    @Transactional
    public User register(User newUser) {

        // validation would go here...

        newUser.setRole(UserRole.BASIC_USER);
        return userRepo.save(newUser);

    }
}