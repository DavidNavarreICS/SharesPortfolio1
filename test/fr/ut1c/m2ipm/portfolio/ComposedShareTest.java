/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1c.m2ipm.portfolio;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David
 */
public class ComposedShareTest {

    public ComposedShareTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        ComposedShare composedShare = new ComposedShare("test");
    }

    /**
     * Test of registerComposition method, of class ComposedShare.
     */
    @Test
    public void testRegisterComposition() {
        System.out.println("registerComposition");
        SimpleShare simpleShare = null;
        float percentage = 0.0F;
        ComposedShare instance = null;
        instance.registerComposition(simpleShare, percentage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class ComposedShare.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Day day = null;
        ComposedShare instance = null;
        float expResult = 0.0F;
        float result = instance.getPrice(day);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class ComposedShare.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        Day day = null;
        float value = 0.0F;
        ComposedShare instance = null;
        instance.setPrice(day, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
