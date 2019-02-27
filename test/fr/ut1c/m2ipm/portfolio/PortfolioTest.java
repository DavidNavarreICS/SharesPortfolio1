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
public class PortfolioTest {

    private static final String DEFAULT_NAME = "name1";
    private static final float DEFAULT_VALUE = 1.0F;
    private static final int DEFAULT_QUANTITY = 2;
    private static final Day DEFAULT_DAY = new Day(1, 1);

    private static final Share SHARE1 = new Share(DEFAULT_NAME) {
        @Override
        public float getPrice(Day day) {
            return DEFAULT_VALUE;
        }
    };

    public PortfolioTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        Portfolio portfolio = new Portfolio();
    }

    @Test
    public void testGetValueWithEmptyPortfolio() {
        Portfolio portfolio = new Portfolio();
        float value = portfolio.getValue(DEFAULT_DAY);
        Assert.assertEquals(0.0F, value, 0.0F);
    }

    @Test
    public void testFirstBuyGetValueWithCorrectParameters() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, DEFAULT_QUANTITY);
        float value = portfolio.getValue(DEFAULT_DAY);
        final float expectedResult = DEFAULT_VALUE * DEFAULT_QUANTITY;
        Assert.assertEquals(expectedResult, value, 0.0F);
    }

    @Test
    public void testAdditionalBuyGetValueWithCorrectParameters() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, DEFAULT_QUANTITY);
        portfolio.buy(SHARE1, DEFAULT_QUANTITY);
        float value = portfolio.getValue(DEFAULT_DAY);
        final float expectedResult = 2 * DEFAULT_VALUE * DEFAULT_QUANTITY;
        Assert.assertEquals(expectedResult, value, 0.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyWithNullShare() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(null, DEFAULT_QUANTITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyWithIncorrectQuantity() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, 0);
    }

    @Test
    public void testFirstSellGetValueWithCorrectParameters() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, 2 * DEFAULT_QUANTITY);
        portfolio.sell(SHARE1, DEFAULT_QUANTITY);
        float value = portfolio.getValue(DEFAULT_DAY);
        final float expectedResult = DEFAULT_VALUE * DEFAULT_QUANTITY;
        Assert.assertEquals(expectedResult, value, 0.0F);
    }

    @Test
    public void testSellTooManyGetValueWithCorrectParameters() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, DEFAULT_QUANTITY);
        portfolio.sell(SHARE1, 2 * DEFAULT_QUANTITY);
        float value = portfolio.getValue(DEFAULT_DAY);
        final float expectedResult = DEFAULT_VALUE * DEFAULT_QUANTITY;
        Assert.assertEquals(expectedResult, value, 0.0F);
    }

    @Test
    public void testSellNotExistingShare() {
        Portfolio portfolio = new Portfolio();
        portfolio.sell(SHARE1, DEFAULT_QUANTITY);
    }

    @Test
    public void testSellAllGetValueWithCorrectParameters() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, DEFAULT_QUANTITY);
        portfolio.sell(SHARE1, DEFAULT_QUANTITY);
        float value = portfolio.getValue(DEFAULT_DAY);
        final float expectedResult = 0.0F;
        Assert.assertEquals(expectedResult, value, 0.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellWithNullShare() {
        Portfolio portfolio = new Portfolio();
        portfolio.sell(null, DEFAULT_QUANTITY);
        float value = portfolio.getValue(DEFAULT_DAY);
        final float expectedResult = 0.0F;
        Assert.assertEquals(expectedResult, value, 0.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellWithIncorrectQuantity() {
        Portfolio portfolio = new Portfolio();
        portfolio.sell(SHARE1, 0);
    }

    @Test
    public void testToString() {
        Portfolio portfolio = new Portfolio();
        portfolio.buy(SHARE1, DEFAULT_QUANTITY);
        String toString = portfolio.toString();
        Assert.assertNotNull(toString);
        Assert.assertTrue(!toString().isEmpty());
    }
}
