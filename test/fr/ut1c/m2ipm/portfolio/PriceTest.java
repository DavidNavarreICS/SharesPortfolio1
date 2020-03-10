package fr.ut1c.m2ipm.portfolio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PriceTest {

    public PriceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        Price price = new Price(new Day(1, 1), 0);
    }
}
