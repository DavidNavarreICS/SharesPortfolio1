/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1c.m2ipm.portfolio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author David
 */
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
