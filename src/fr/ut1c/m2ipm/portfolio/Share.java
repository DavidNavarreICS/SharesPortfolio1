package fr.ut1c.m2ipm.portfolio;

import java.util.Objects;
/**
 * Class Share.
 * @author 21613265
 */
public abstract class Share {
    /**
     * Parameter about the name of Share.
     */
    private String name;
    /**
     * Method which can return the name of a Share.
     * @return return the name of share.
     */
    public final String getName() {
        return name;
    }
    /**
     * Constractor of a Share.
     * @param name parameter which can identify a Share.
     */
    public Share(final String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("The share name must be defined.");
        }
        this.name = name;
    }
    /**
     * Abstract method which allowed to get the price of a share of one day.
     * @param day parameter day is a date of which we want to get the price of.
     * @return price of a share of one day.
     */
    public abstract float getPrice(Day day);

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }
    /**
     * Method which can identify if two value are equal.
     * @param obj 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Share other = (Share) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc} Method which allowed to convert a value into String.
     */
    @Override
    public final String toString() {
        return this.getName();
    }
}
