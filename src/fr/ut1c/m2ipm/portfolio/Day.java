/*
 * Portfolio, open source software.
 * Copyright (C) 2014-2019 M2 MIAGE IPM
 * mailto:navarre@irit.fr
 *
 * Portfolio is free software; you can redistribute it and/or
 * modify it under the terms of any License.
 *
 * Portfolio is distributed in the hope that it will be useless,
 * but WITHOUT ANY WARRANTY.
 */
package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

/**
 * This class allows the construction of Days.
 * <br>An object of this class represents a particular day defined by:
 * <ul>
 * <li>a day number (>0)</li>
 * <li>a year number (>0)</li>
 * </ul>
 *
 * @author David Navarre
 */
public final class Day {

    /**
     * Error message for day value negative or null.
     */
    private static final String DAY_NEGATIVE_ERROR
            = "The day must be strictly positive";
    /**
     * Error message for year value negative or null.
     */
    private static final String YEAR_NEGATIVE_ERROR
            = "The year must be strictly positive";
    /**
     * Used to compute hascode.
     *
     * @see #hashCode()
     */
    private static final int BASE_HASHCODE_VALUE = 7;
    /**
     * Used to compute hascode.
     *
     * @see #hashCode()
     */
    private static final int BASE_HASHCODE_FACTOR = 53;
    /**
     * The year number must be >0.
     */
    private final int year;
    /**
     * The day number must be > 0.
     */
    private final int dayNumber;
    /**
     * The hashcode can be computed when the constructor is called.
     */
    private final int hashcode;

    /**
     * Build a day as a tuple <code>[year, day]</code>.
     *
     * @param aYear the year that defines the day. It must be >0
     * @param aDayNumber the day that defines the day. It must be >0
     */
    public Day(final int aYear, final int aDayNumber) {
        if (aYear <= 0) {
            throw new IllegalArgumentException(YEAR_NEGATIVE_ERROR);
        }
        if (aDayNumber <= 0) {
            throw new IllegalArgumentException(DAY_NEGATIVE_ERROR);
        }
        this.year = aYear;
        this.dayNumber = aDayNumber;

        int hash = BASE_HASHCODE_VALUE;
        hash = BASE_HASHCODE_FACTOR * hash + this.year;
        hash = BASE_HASHCODE_FACTOR * hash + this.dayNumber;

        hashcode = hash;
    }

    /**
     * Provide read access to the year that defines the day. This method is not
     * designed to be derived.
     *
     * @return the year >0
     */
    public int getYear() {
        return year;
    }

    /**
     * Provide read access to the day that defines the object day.
     *
     * @return the day >0
     */
    public int getDayNumber() {
        return dayNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return hashcode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Day other = (Day) obj;
        return Objects.equals(this.year, other.year)
                && Objects.equals(this.dayNumber, other.dayNumber);
    }

}
