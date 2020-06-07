package com.revature.p2.services;

import com.revature.p2.exceptions.BadRequestException;
import com.revature.p2.exceptions.ResourceNotFoundException;
import com.revature.p2.models.Good;
import com.revature.p2.models.Planet;
import com.revature.p2.repos.GoodRepo;
import com.revature.p2.web.dtos.GoodDTO;
import com.revature.p2.web.dtos.PlanetDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GoodServiceTest {

    @Mock
    private static GoodRepo mockRepo;

    private static GoodService sut;

    private static List<Good> mockGoods;

    @BeforeClass
    public static void setUp() {
        mockRepo = mock(GoodRepo.class);
        mockGoods = new ArrayList<>();
        sut = new GoodService(mockRepo);
        Good g1 = new Good(1, "g1", "d1", 1);
        Good g2 = new Good(2, "g2", "d2", 2);
        Good g3 = new Good(3, "g3", "d3", 3);
        mockGoods.add(g1);
        mockGoods.add(g2);
        mockGoods.add(g3);
    }

    @Test
    public void getAllGoodsTest() {
        when(mockRepo.findAll()).thenReturn(mockGoods);

        List<GoodDTO> goods = sut.getAllGoods();

        assertEquals(goods.size(), 3);
    }

    @Test
    public void getByIdTest() {
        when(mockRepo.findById(1)).thenReturn(mockGoods.get(1));

        GoodDTO good = sut.getGoodById(1);

        assert(good.equals(new GoodDTO(mockGoods.get(1))));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getByIdException1() {
        List<Good> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(null);

        sut.getGoodById(1);
    }

    @Test(expected = BadRequestException.class)
    public void getByIdException2() {
        List<Good> test = new ArrayList<>();
        when(mockRepo.findById(1)).thenReturn(mockGoods.get(1));

        sut.getGoodById(0);
    }

    @Test
    public void registerTest() {
        when(mockRepo.save(mockGoods.get(1))).thenReturn(mockGoods.get(1));

        GoodDTO good = sut.register(mockGoods.get(1));

        assertEquals(good, new GoodDTO(mockGoods.get(1)));
    }
}
