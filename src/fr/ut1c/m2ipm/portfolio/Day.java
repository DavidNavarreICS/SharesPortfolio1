package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;

public class Day {

    private int year;
    private int dayNumber;

    public int getYear() {
        return year;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public Day(int year, int dayNumber) {
        this.year = year;
        this.dayNumber = dayNumber;
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
