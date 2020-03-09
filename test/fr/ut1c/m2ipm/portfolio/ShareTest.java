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
public class ShareTest {
    /**
     * Tests for class Share.
     */
    public ShareTest() {
    }
    /**
     * Actions befor test.
     */
    @Before
    public void setUp() {
    }
    /**
     * Actions after test.
     */
    @After
    public void tearDown() {
    }
    /**
     * Test for class share.
     */
    @Test
    public final void testConstructor() {
        Share share = new Share("test") {
            @Override
            public float getPrice(final Day day) {
                //To change body of generated methods, choose Tools | Templates.
                throw new UnsupportedOperationException("Not supported yet.");

            }
            @Override
            public void setPrice(final Day day, final float value) {
                //To change body of generated methods, choose Tools | Templates.
                throw new UnsupportedOperationException("Not supported yet.");

            }
        };
    }
}
