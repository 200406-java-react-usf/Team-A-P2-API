package com.revature.p2.services;

import com.revature.p2.exceptions.*;
import com.revature.p2.models.User;
import com.revature.p2.models.UserRole;
import com.revature.p2.repos.UserRepo;
import com.revature.p2.web.dtos.Creds;
import com.revature.p2.web.dtos.Principal;
import com.revature.p2.web.dtos.UserDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private static UserRepo mockRepo;

    private static UserService sut;

    private static List<User> mockUsers;

    @BeforeClass
    public static void setUp() {
        mockRepo = mock(UserRepo.class);
        mockUsers = new ArrayList<>();
        sut = new UserService(mockRepo);
        User uOne = new User("test1un", "test1pw", 100, 1000.00, 1);
        uOne.setRole(UserRole.ADMIN);
        User uTwo = new User("test2un", "test2pw", 100, 1000.00, 1);
        User uThree = new User("test3un", "test3pw", 100, 1000.00, 1);
        User uFour = new User("test4un", "test4pw", 100, 1000.00, 1);
        User uFive = new User("test5un", "test5pw", 100, 1000.00, 1);
        mockUsers.add(uOne);
        mockUsers.add(uTwo);
        mockUsers.add(uThree);
        mockUsers.add(uFour);
        mockUsers.add(uFive);

    }

    @Test
    public void getALlUsersTest() {
        when(mockRepo.findAll()).thenReturn(mockUsers);

        List<UserDTO> users = sut.getAllUsers();

        assertEquals(users.size(), 5);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getALlUsersException() {
        List<User> test = new ArrayList<>();
        when(mockRepo.findAll()).thenThrow();

        sut.getAllUsers();
    }

    @Test
    public void getByIdTest() {
        when(mockRepo.findById(1)).thenReturn(mockUsers.get(1));

        UserDTO user = sut.getUserById(1);

        assert(user.equals(new UserDTO(mockUsers.get(1))));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getByIdException1() {
        List<User> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(null);

        sut.getUserById(1);
    }

    @Test(expected = BadRequestException.class)
    public void getByIdException2() {
        List<User> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(mockUsers.get(1));

        sut.getUserById(0);
    }

    @Test
    public void findUserByCredsTest() {

        when(mockRepo.findUserByCreds("test1un", "test1pw")).thenReturn(mockUsers.get(1));

        Principal user = sut.authenticate(new Creds("test1un", "test1pw"));

        assert(user.equals(new Principal(mockUsers.get(1))));
    }

    @Test(expected = BadRequestException.class)
    public void findUserByCredsException1() {
        when(mockRepo.findUserByCreds("test1un", "test1pw")).thenReturn(mockUsers.get(1));

        Principal user = sut.authenticate(new Creds("", "test1pw"));
    }

    @Test(expected = BadRequestException.class)
    public void findUserByCredsException2() {
        when(mockRepo.findUserByCreds("test1un", "test1pw")).thenReturn(mockUsers.get(1));

        Principal user = sut.authenticate(new Creds("test1un", ""));

    }

//    @Test(expected = AuthenticationException.class)
//    public void findUserByCredsException3() {
//        when(mockRepo.findUserByCreds("test1un", "test1pw")).thenReturn(mockUsers.get(1));
//
//        Principal user = sut.authenticate(new Creds("wrong", "wrong"));
//
//    }

    @Test
    public void registerTest() {
        when(mockRepo.save(mockUsers.get(1))).thenReturn(mockUsers.get(1));

        UserDTO user = sut.register(mockUsers.get(1));

        assertEquals(user, new UserDTO(mockUsers.get(1)));
    }

    @Test(expected = BadRequestException.class)
    public void registerException1() {
        when(mockRepo.save(mockUsers.get(1))).thenReturn(mockUsers.get(1));

        UserDTO user = sut.register(null);
    }

//    @Test(expected = ResourcePersistenceException.class)
//    public void registerException2() {
//        when(mockRepo.save(mockUsers.get(1))).thenReturn(mockUsers.get(1));
//
//        UserDTO user = sut.register(new User("test1un", "test1pw", 100, 1000.00, 1));
//    }

    @Test
    public void updateTest() {
        when(mockRepo.update(mockUsers.get(1))).thenReturn(true);

        boolean updated = sut.update(mockUsers.get(1));

        assertEquals(updated, true);
    }

    @Test(expected = BadRequestException.class)
    public void updateException1() {
        when(mockRepo.update(mockUsers.get(1))).thenReturn(false);

        boolean updated = sut.update(null);
    }

    @Test
    public void deleteTest() {
        when(mockRepo.deleteById(1)).thenReturn(true);

        boolean user = sut.delete(1);

        assertEquals(user, true);
    }

    @Test(expected = InternalServerErrorException.class)
    public void deleteException() {
        when(mockRepo.deleteById(1)).thenThrow();

        boolean user = sut.delete(1);

        assert(user);
    }



}
