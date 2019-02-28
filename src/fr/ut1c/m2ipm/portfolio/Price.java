/*
 * Portfolio, open source software.
 * Copyright (C) 2014-2019 SonarSource
 * mailto:navarre@irit.fr
 *
 * Portfolio is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Portfolio is distributed in the hope that it will be useless,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

/**
 * Objects from this class allow to store the price of any share for a given
 * day.
 *
 * @author David Navarre
 */
public final class Price {

    /**
     * Error message for a null day.
     */
    private static final String INVALID_DAY
            = "The day cannot be null";
    /**
     * Error message for a negative or null value.
     */
    private static final String INVALID_VALUE
            = "The value cannot be negative or null";
    /**
     * The day for the definition of a price cannot be null.
     */
    private final Day day;

    /**
     * The price cannot be negative or null.
     */
    private final float value;

    /**
     * Defines a Price with a float value for a given day.
     *
     * @param aDay is a non null value
     * @param aValue is a >0 value
     */
    public Price(final Day aDay, final float aValue) {
        if (Objects.isNull(aDay)) {
            throw new IllegalArgumentException(INVALID_DAY);
        }
        if (aValue <= 0) {
            throw new IllegalArgumentException(INVALID_VALUE);
        }
        this.day = aDay;
        this.value = aValue;
    }

    /**
     * Provide read access to the value of the price.
     *
     * @return the value of the price
     */
    public float getValue() {
        return value;
    }

    /**
     * Provide read access to the day of definition of the price.
     *
     * @return the day of definition of the price
     */
    public Day getDay() {
        return day;
    }
}
