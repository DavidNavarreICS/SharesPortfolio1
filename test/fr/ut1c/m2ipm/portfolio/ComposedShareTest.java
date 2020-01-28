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
public class ComposedShareTest {

    private static final String WELL_FORMED_NAME1 = "name1";
    private static final String WELL_FORMED_NAME2 = "name2";
    private static final String WELL_FORMED_NAME3 = "name3";
    private static final String MALFORMED_NAME = "";
    private static final String NULL_NAME = null;
    private static final Day DEFAULT_DAY = new Day(1, 1);
    private static final float DEFAULT_VALUE1 = 0.3F;
    private static final float DEFAULT_VALUE2 = 0.7F;
    private static final float DEFAULT_PRICE1 = 10.0F;
    private static final SimpleShare SIMPLESHARE1 = new SimpleShare(
            WELL_FORMED_NAME2);
    private static final SimpleShare SIMPLESHARE2 = new SimpleShare(
            WELL_FORMED_NAME3);

    static {
        SIMPLESHARE1.setPrice(DEFAULT_DAY, DEFAULT_PRICE1);
    }

    public ComposedShareTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorWithCorrectParameter() {
        new ComposedShare(WELL_FORMED_NAME1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInorrectParameter() {
        new ComposedShare(MALFORMED_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullParameter() {
        new ComposedShare(NULL_NAME);
    }

    @Test
    public void testRegisterCompositionWithCorrectParameters() {
        ComposedShare share = new ComposedShare(WELL_FORMED_NAME1);
        share.registerComposition(SIMPLESHARE1, DEFAULT_VALUE1);
        float value = share.getPrice(DEFAULT_DAY);
        float expectedPrice = DEFAULT_VALUE1 * DEFAULT_PRICE1;
        Assert.assertEquals(expectedPrice, value, 0.0F);
    }

    @Test
    public void testEqualsSame() {
        SimpleShare share1 = new SimpleShare(WELL_FORMED_NAME1);
        SimpleShare share2 = new SimpleShare(WELL_FORMED_NAME1);
        Boolean answer = share1.equals(share2);
        Assert.assertTrue(answer);
    }

    @Test
    public void testEqualsDifferent() {
        SimpleShare share1 = new SimpleShare(WELL_FORMED_NAME1);
        SimpleShare share2 = new SimpleShare(WELL_FORMED_NAME2);
        Assert.assertFalse(WELL_FORMED_NAME1.equals(WELL_FORMED_NAME2));
        Boolean answer = share1.equals(share2);
        Assert.assertFalse(answer);
    }
}
