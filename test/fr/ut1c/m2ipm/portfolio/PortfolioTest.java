/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1c.m2ipm.portfolio;

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
    public void testGetMapLines() {
        Portfolio portfolio = new Portfolio();
        Map<Share, Portfolio.PortfolioLine> mapLines = portfolio.getMapLines();
        Assert.assertNotNull("the mapLines should not be null even if there is no share", mapLines);
    }

    @Test
    public void testBuyNewShare() {
        Portfolio portfolio = new Portfolio();
        Share simpleShare = new SimpleShare("simpleShare1");
        portfolio.buy(simpleShare, 1);
    }

    @Test
    public void testBuyExtraShare() {
        Portfolio portfolio = new Portfolio();
        Share simpleShare = new SimpleShare("simpleShare1");
        portfolio.buy(simpleShare, 1);
        portfolio.buy(simpleShare, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyZeroShare() {
        Portfolio portfolio = new Portfolio();
        Share simpleShare = new SimpleShare("simpleShare1");
        portfolio.buy(simpleShare, 1);
        portfolio.buy(simpleShare, 1);
    }

}
