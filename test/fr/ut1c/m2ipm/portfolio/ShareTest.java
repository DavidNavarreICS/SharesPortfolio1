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
 *
 * @author David
 */
public class ShareTest {

    private static final String WELL_FORMED_NAME1 = "name1";
    private static final String WELL_FORMED_NAME2 = "name2";
    private static final String MALFORMED_NAME = "";
    private static final String NULL_NAME = null;

    public ShareTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorWithCorrectParameter() {
        getNewShare(WELL_FORMED_NAME1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInorrectParameter() {
        getNewShare(MALFORMED_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullParameter() {
        getNewShare(NULL_NAME);
    }

    @Test
    public void testGetNameReturnsSame() {
        AbstractShare share = getNewShare(WELL_FORMED_NAME1);
        String name = share.getName();
        Assert.assertSame(name, WELL_FORMED_NAME1);
    }

    @Test
    public void testToStringReturnsNotNull() {
        AbstractShare share = getNewShare(WELL_FORMED_NAME1);
        String toString = share.toString();
        Assert.assertNotNull(toString);
    }

    @Test
    public void testHashcodeIsDefined() {
        AbstractShare share = getNewShare(WELL_FORMED_NAME1);
        int code = share.hashCode();
        Assert.assertTrue(code != 0);
    }

    @Test
    public void testEqualsWithSameObject() {
        AbstractShare share = getNewShare(WELL_FORMED_NAME1);
        Assert.assertTrue(share.equals(share));
    }

    @Test
    public void testEqualsWithSameName() {
        AbstractShare share1 = getNewShare(WELL_FORMED_NAME1);
        AbstractShare share2 = getNewShare(WELL_FORMED_NAME1);
        Assert.assertTrue(share1.equals(share2));
        Assert.assertTrue(share2.equals(share1));
    }

    @Test
    public void testNotEqualsWithSameNameWithDifferentClass() {
        AbstractShare share1 = new SharePrototype(WELL_FORMED_NAME1);
        AbstractShare share2 = new SharePrototype2(WELL_FORMED_NAME1);
        Assert.assertFalse(share1.equals(share2));
        Assert.assertFalse(share2.equals(share1));
    }

    @Test
    public void testNotEqualsWithDifferentName() {
        AbstractShare share1 = getNewShare(WELL_FORMED_NAME1);
        AbstractShare share2 = getNewShare(WELL_FORMED_NAME2);
        Assert.assertFalse(share1.equals(share2));
        Assert.assertFalse(share2.equals(share1));
    }

    @Test
    public void testNotEqualsWithDifferentClass() {
        AbstractShare share1 = getNewShare(WELL_FORMED_NAME1);
        Object share2 = new Object();
        Assert.assertFalse(share1.equals(share2));
        Assert.assertFalse(share2.equals(share1));
    }

    @Test
    public void testNotEqualsWithNullObject() {
        AbstractShare share1 = getNewShare(WELL_FORMED_NAME1);
        Object share2 = null;
        Assert.assertFalse(share1.equals(share2));
    }

    private AbstractShare getNewShare(String name) {
        return new SharePrototype(name);
    }

    private static class SharePrototype extends AbstractShare {

        public SharePrototype(String aName) {
            super(aName);
        }

        @Override
        public float getPrice(Day day) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private static class SharePrototype2 extends AbstractShare {

        public SharePrototype2(String aName) {
            super(aName);
        }

        @Override
        public float getPrice(Day day) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
