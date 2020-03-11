/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author David
 */
public class PortfolioTest {

    Portfolio portfolio = new Portfolio();
    Share simpleShare = new SimpleShare("simpleShare1");
    Share composedShare = new ComposedShare("composedShare");

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
        Portfolio pf = new Portfolio();
    }

    @Test
    public void testGetMapLines() {
        Map<Share, Portfolio.PortfolioLine> mapLines = portfolio.getMapLines();
        Assert.assertNotNull("the mapLines should not be null even if there is no share", mapLines);
    }

    /**
     * tests for buy.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuyNegativeOrZeroShare() {
        portfolio.buy(simpleShare, 0);
    }

    @Test
    public void testBuyNewShare() {
        portfolio.buy(simpleShare, 1);
        Assert.assertEquals(1, portfolio.getMapLines().get(simpleShare).getQuantity());
    }

    @Test
    public void testBuyExtraShare() {
        portfolio.buy(simpleShare, 1);
        portfolio.buy(simpleShare, 1);
        Assert.assertEquals(2, portfolio.getMapLines().get(simpleShare).getQuantity());
    }

    /**
     * tests for sell
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSellNegativeOrZeroShare() {
        portfolio.sell(simpleShare, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellNotExistShare() {
        Share shareTest = new SimpleShare("SimpleShare1");
        portfolio.sell(shareTest, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellShareNotEnough() {
        portfolio.buy(simpleShare, 1);
        portfolio.sell(simpleShare, 2);
    }

    @Test
    public void testSellPartOfShare() {
        portfolio.buy(simpleShare, 2);
        portfolio.sell(simpleShare, 1);
        Assert.assertEquals(1, portfolio.getMapLines().get(simpleShare).getQuantity());
    }

    @Test
    public void testSellAllQteOfShare() {
        portfolio.buy(simpleShare, 1);
        portfolio.sell(simpleShare, 1);
        Assert.assertNull(portfolio.getMapLines().get(simpleShare));
    }

    /**
     * tests getvalue
     */
    @Test
    public void testGetZeroValue() {
        float value = portfolio.getValue(new Day(2020, 1));
        Assert.assertEquals(0f, value);
    }

    @Test
    public void testGetValueWithShare() {
        portfolio.buy(simpleShare, 1);
        Day aDay = new Day(2020, 1);
        float value = portfolio.getValue(aDay);
        Assert.assertEquals(simpleShare.getPrice(aDay) * 1f, value);
    }

/**
 * Tests toString
 */
    @Test
    public void testeToStringPortfolio(){
        String s = new HashMap<>().toString();
        Assert.assertEquals(s, portfolio.toString());
    }
        @Test
    public void testeToStringPortfolioLine(){
        portfolio.buy(simpleShare, 1);
       String s1 = portfolio.getMapLines().get(simpleShare).toString();
       String s ="1";
        Assert.assertEquals(s1, s);
    }
}
