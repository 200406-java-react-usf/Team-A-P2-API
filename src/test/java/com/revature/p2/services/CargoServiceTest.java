package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Cargo;
import com.revature.p2.models.Planet;
import com.revature.p2.repos.CargoRepo;
import com.revature.p2.repos.UserRepo;
import com.revature.p2.web.dtos.CargoDTO;
import com.revature.p2.web.dtos.PlanetDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CargoServiceTest {

    @Mock
    private static CargoRepo mockRepo;

    private static UserRepo mockUrepo;

    private static CargoService sut;

    private static List<Cargo> mockCargos;

    @BeforeClass
    public static void setUp() {
        mockRepo = mock(CargoRepo.class);
        mockUrepo = mock(UserRepo.class);
        mockCargos = new ArrayList<>();
        sut = new CargoService(mockRepo, mockUrepo);
        Cargo c1 = new Cargo(1, 1, 1);
        Cargo c2 = new Cargo(2, 2,2);
        Cargo c3 = new Cargo(3,3,3);
        mockCargos.add(c1);
        mockCargos.add(c2);
        mockCargos.add(c3);
    }

    @Test
    public void getAllPlanetsTest() {
        when(mockRepo.findAll()).thenReturn(mockCargos);

        List<CargoDTO> cargos = sut.getAllCargos();

        assertEquals(cargos.size(), 3);
    }

    @Test
    public void getByIdTest() {
        when(mockRepo.findById(1)).thenReturn(mockCargos.get(1));

        CargoDTO cargos = sut.getCargoById(1);

        assert(cargos.equals(new CargoDTO(mockCargos.get(1))));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getByIdException1() {
        List<Cargo> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(null);

        sut.getCargoById(1);
    }

    @Test(expected = BadRequestException.class)
    public void getByIdException2() {
        List<Cargo> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(mockCargos.get(1));

        sut.getCargoById(0);
    }

    @Test
    public void registerTest() {
        when(mockRepo.save(mockCargos.get(1))).thenReturn(mockCargos.get(1));

        CargoDTO cargos = sut.register(mockCargos.get(1));

        assertEquals(cargos, new CargoDTO(mockCargos.get(1)));
    }

//    @Test
//    public void updateTest() {
//        when(mockRepo.update(mockCargos.get(1))).thenReturn(true);
//
//        boolean updated = sut.updateCargo(mockCargos.get(1));
//
//        assertEquals(updated, true);
//    }
}
