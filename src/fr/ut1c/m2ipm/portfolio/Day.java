package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

/**
 * Class for describing a date.
 *
 * @author hm
 */
public final class Day {

    /**
     * Parameter for describing a year.
     */
    private int year;
    /**
     * Parameter for describing a day of year randing beyween 1 and 366
     * (starting on January 1).
     */
    private int dayNumber;

    /**
     * Getter of Parameter year.
     *
     * @return value of Parameter year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter of Parameter dayNumber.
     *
     * @return value of Parameter dayNumber
     */
    public int getDayNumber() {
        return dayNumber;
    }

    /**
     * Build a day owning two parameters that must be strickly positive.
     *
     * @param aYear the value of year
     * @param aDayNumber the value of day
     *
     */
    public Day(final int aYear, final int aDayNumber) {
        if (aYear <= 0) {
            throw new IllegalArgumentException("Year value not allowed");
        }
        if (aDayNumber <= 0) {
            throw new IllegalArgumentException("Day number value not allowed");
        }
        this.year = aYear;
        this.dayNumber = aDayNumber;
    }

    @Override
    public int hashCode() {
        final int dayWeeek = 7;
        final int weekYear = 61;
        int hash;
        hash = weekYear * dayWeeek + this.year;
        hash = weekYear * hash + this.dayNumber;
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
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
