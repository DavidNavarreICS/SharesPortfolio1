package fr.ut1c.m2ipm.portfolio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShareTest {

    public ShareTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        Share share = new Share("test") {
            @Override
            public float getPrice(Day day) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
