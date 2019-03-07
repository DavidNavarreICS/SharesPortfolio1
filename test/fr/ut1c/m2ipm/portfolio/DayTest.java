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
public class DayTest {

    public DayTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectYear() {
        Day day = new Day(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectDay() {
        Day day = new Day(1, 0);
    }

    @Test
    public void testConstructorWithCorrectParameters() {
        Day day = new Day(1, 1);
    }
}
