/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1c.m2ipm.portfolio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author David
 */
public class PriceTest {

    private static final Day DEFAULT_DAY = new Day(1, 1);
    private static final float DEFAULT_VALUE = 1.0F;

    public PriceTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullDay() {
        Price price = new Price(null, DEFAULT_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNonValidValue() {
        Price price = new Price(DEFAULT_DAY, 0.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectParameters() {
        Price price = new Price(null, 0.0F);
    }

    @Test
    public void testGetValueIsSame() {
        Price price = new Price(DEFAULT_DAY, DEFAULT_VALUE);
        float value = price.getValue();
        Assert.assertEquals(
                "The value of the price should be the one used for creting it",
                DEFAULT_VALUE, value, 0.0F);
    }

    @Test
    public void testGetDayIsSame() {
        Price price = new Price(DEFAULT_DAY, DEFAULT_VALUE);
        Day day = price.getDay();
        Assert.assertNotNull("Dummy test", day);
        Assert.assertSame(
                "The value of the day should be the one used for creating it",
                DEFAULT_DAY, day);
        Assert.assertEquals(
                "The value of the day should be the one used for creating it",
                DEFAULT_DAY, day);
    }
}
