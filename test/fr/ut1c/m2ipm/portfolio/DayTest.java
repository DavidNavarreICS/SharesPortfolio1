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
public class DayTest {

    private static final int NON_NULL_VALUE1 = 1;
    private static final int NON_NULL_VALUE2 = 2;

    public DayTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectYear() {
        Day day = new Day(0, NON_NULL_VALUE1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectDay() {
        Day day = new Day(NON_NULL_VALUE1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIncorrectParameters() {
        Day day = new Day(0, 0);
    }

    @Test
    public void testGetYear() {
        Day day = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        int year = day.getYear();
        Assert.assertEquals(
                "The getted year should be the same as the one used to build the Day object",
                NON_NULL_VALUE1, year);
    }

    @Test
    public void testGetDayNumber() {
        Day day = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        int dayNumber = day.getDayNumber();
        Assert.assertEquals(
                "The getted day number should be the same as the one used to build the Day object",
                NON_NULL_VALUE1, dayNumber);
    }

    @Test
    public void testHashcodeIsDefined() {
        Day day = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        int code = day.hashCode();
        Assert.assertTrue("The hashcode cannot be equal to 0", code != 0);
    }

    @Test
    public void testEqualsWithSameValues() {
        Day day1 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        Day day2 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        boolean answer1 = day1.equals(day2);
        Assert.assertTrue(
                "Two Day objects built with the same values should be equals",
                answer1);
        boolean answer2 = day2.equals(day1);
        Assert.assertTrue(
                "Two Day objects built with the same values should be equals",
                answer2);
    }

    @Test
    public void testEqualsWithSameYearWithDifferentDay() {
        Day day1 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        Day day2 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE2);
        boolean answer1 = day1.equals(day2);
        Assert.assertFalse(
                "Two Day objects built with different day value should not be equals",
                answer1);
        boolean answer2 = day2.equals(day1);
        Assert.assertFalse(
                "Two Day objects built with different day value should not be equals",
                answer2);
    }

    @Test
    public void testEqualsWithSameDayWithDifferentYear() {
        Day day1 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        Day day2 = new Day(NON_NULL_VALUE2, NON_NULL_VALUE1);
        boolean answer1 = day1.equals(day2);
        Assert.assertFalse(
                "Two Day objects built with different year value should not be equals",
                answer1);
        boolean answer2 = day2.equals(day1);
        Assert.assertFalse(
                "Two Day objects built with different year value should not be equals",
                answer2);
    }

    @Test
    public void testNotEqualsWithDifferentValues() {
        Day day1 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        Day day2 = new Day(NON_NULL_VALUE2, NON_NULL_VALUE2);
        boolean answer1 = day1.equals(day2);
        Assert.assertFalse(
                "Two Day objects built with different values should not be equals",
                answer1);
        boolean answer2 = day2.equals(day1);
        Assert.assertFalse(
                "Two Day objects built with different values should not be equals",
                answer2);
    }

    @Test
    public void testNotEqualsWithDifferentClass() {
        Day day1 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        Object day2 = new Object();
        boolean answer1 = day1.equals(day2);
        Assert.assertFalse(
                "Two objects of different classes should not be equals", answer1);
        boolean answer2 = day2.equals(day1);
        Assert.assertFalse(
                "Two objects of different classes should not be equals",
                answer2);
    }

    @Test
    public void testNotEqualsWithNullObject() {
        Day day1 = new Day(NON_NULL_VALUE1, NON_NULL_VALUE1);
        Object day2 = null;
        boolean answer1 = day1.equals(day2);
        Assert.assertFalse("A day object cannot be equals to null", answer1);
    }

}
