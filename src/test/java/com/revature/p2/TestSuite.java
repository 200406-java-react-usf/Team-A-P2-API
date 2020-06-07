package com.revature.p2;

import com.revature.p2.services.CargoServiceTest;
import com.revature.p2.services.GoodServiceTest;
import com.revature.p2.services.PlanetServiceTest;
import com.revature.p2.services.UserServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceTest.class,
        PlanetServiceTest.class,
        GoodServiceTest.class,
        CargoServiceTest.class
})

public class TestSuite {
}
