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
public class SimpleShareTest {

    private static final String WELL_FORMED_NAME1 = "name1";
    private static final String WELL_FORMED_NAME2 = "name2";
    private static final String MALFORMED_NAME = "";
    private static final String NULL_NAME = null;
    private static final Day DEFAULT_DAY = new Day(1, 1);
    private static final float DEFAULT_VALUE1 = 1.0F;
    private static final float DEFAULT_VALUE2 = 2.0F;

    public SimpleShareTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInorrectParameter() {
        new SimpleShare(MALFORMED_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullParameter() {
        new SimpleShare(NULL_NAME);
    }

    @Test
    public void testSetGetPriceWithCorrectValues() {
        SimpleShare share = new SimpleShare(WELL_FORMED_NAME1);
        share.setPrice(DEFAULT_DAY, DEFAULT_VALUE1);
        float value = share.getPrice(DEFAULT_DAY);
        Assert.
                assertEquals(
                        "The price should be the same as the one registered",
                        DEFAULT_VALUE1, value, 0.0F);
    }

    @Test
    public void testSetGetPriceTwiceWithCorrectValues() {
        SimpleShare share = new SimpleShare(WELL_FORMED_NAME1);
        share.setPrice(DEFAULT_DAY, DEFAULT_VALUE1);
        share.setPrice(DEFAULT_DAY, DEFAULT_VALUE2);
        float value = share.getPrice(DEFAULT_DAY);
        Assert.assertEquals("The price can only be set once", DEFAULT_VALUE1,
                value, 0.0F);
    }

    @Test
    public void testGetPriceWhenNotDefined() {
        SimpleShare share = new SimpleShare(WELL_FORMED_NAME1);
        float value = share.getPrice(DEFAULT_DAY);
        Assert.assertEquals("The default price should be 0.0F", 0.0F, value,
                0.0F);
    }

    @Test
    public void testEqualsSame() {
        SimpleShare share1 = new SimpleShare(WELL_FORMED_NAME1);
        SimpleShare share2 = new SimpleShare(WELL_FORMED_NAME1);
        Boolean answer = share1.equals(share2);
        Assert.assertTrue(
                "Twe simpleshares with the same name should be considered as equals",
                answer);
    }

    @Test
    public void testEqualsDifferent() {
        SimpleShare share1 = new SimpleShare(WELL_FORMED_NAME1);
        SimpleShare share2 = new SimpleShare(WELL_FORMED_NAME2);
        Assert.assertFalse(
                "The two strings must be differents for the correctness of the test",
                WELL_FORMED_NAME1.equals(WELL_FORMED_NAME2));
        Boolean answer = share1.equals(share2);
        Assert.assertFalse(
                "Two simpleshares with different names should be considered as different",
                answer);
    }

}
