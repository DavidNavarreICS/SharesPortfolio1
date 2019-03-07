package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

/**
 * This class ...
 *
 * @author David
 */
public class Day {

    private int year;
    private int dayNumber;

    public int getYear() {
        return year;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    /**
     * Build an object of class Day with a year and a day number.
     *
     * @param aYear must be strictly positive
     * @param aDayNumber must be strictly positive
     */
    public Day(final int aYear, final int aDayNumber) {
        if (aYear <= 0) {
            throw new IllegalArgumentException("Year must be strictly positive.");
        }
        if (aDayNumber <= 0) {
            throw new IllegalArgumentException("Day number must be strictly positive.");
        }
        this.year = aYear;
        this.dayNumber = aDayNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.year;
        hash = 61 * hash + this.dayNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Day other = (Day) obj;
        if (this.year != other.year) {
            return false;
        }
        return Objects.equals(this.dayNumber, other.dayNumber);
    }

}
