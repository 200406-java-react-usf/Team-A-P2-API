package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Planet;
import com.revature.p2.repos.PlanetRepo;
import com.revature.p2.web.dtos.PlanetDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlanetServiceTest {

    @Mock
    private static PlanetRepo mockRepo;

    private static PlanetService sut;

    private static List<Planet> mockPlanets;

    @BeforeClass
    public static void setUp() {
        mockRepo = mock(PlanetRepo.class);
        mockPlanets = new ArrayList<>();
        sut = new PlanetService(mockRepo);
        Planet p1 = new Planet(1, "test1");
        Planet p2 = new Planet(2, "test2");
        Planet p3 = new Planet(3, "test3");
        mockPlanets.add(p1);
        mockPlanets.add(p2);
        mockPlanets.add(p3);
    }

    @Test
    public void getAllPlanetsTest() {
        when(mockRepo.findAll()).thenReturn(mockPlanets);

        List<PlanetDTO> planets = sut.getAllPlanets();

        assertEquals(planets.size(), 3);
    }

    @Test
    public void getByIdTest() {
        when(mockRepo.findById(1)).thenReturn(mockPlanets.get(1));

        PlanetDTO planet = sut.getPlanetById(1);

        assert(planet.equals(new PlanetDTO(mockPlanets.get(1))));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getByIdException1() {
        List<Planet> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(null);

        sut.getPlanetById(1);
    }

    @Test(expected = BadRequestException.class)
    public void getByIdException2() {
        List<Planet> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(mockPlanets.get(1));

        sut.getPlanetById(0);
    }

    @Test
    public void registerTest() {
        when(mockRepo.save(mockPlanets.get(1))).thenReturn(mockPlanets.get(1));

        PlanetDTO planet = sut.register(mockPlanets.get(1));

        assertEquals(planet, new PlanetDTO(mockPlanets.get(1)));
    }
}
