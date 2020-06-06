package com.revature.p2.services;

import com.revature.p2.models.User;
import com.revature.p2.models.UserRole;
import com.revature.p2.repos.UserRepo;
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
}
