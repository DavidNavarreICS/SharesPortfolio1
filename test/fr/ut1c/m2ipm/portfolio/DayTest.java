/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1c.m2ipm.portfolio;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *Day test class.
 * @author David
 */
public final class DayTest {

    /**
     * Methode of test.
     */
    public DayTest() {
    }

     /**
     * Action before test begin.
     */
    @Before
    public void setUp() {
    }

    /**
     * Action after test end.
     */
    @After
    public void tearDown() {
    }

    /**
     * in day class constructor, if  parameters is incorrect,
     * thows an IllegalArgumentException error.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectParameters() {
        Day day = new Day(0, 0);
    }
    
    /**
     * in day class constructor, if parameters is correct,
     * no error throwed.
     */
    @Test
    public void testConstructorWithCorrectParameters() {
        Day day = new Day(1, 1);
        int year = day.getYear();
        Assert.assertEquals("The value of year", 1, year);
    }
}
