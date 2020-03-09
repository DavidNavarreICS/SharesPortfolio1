package fr.ut1c.m2ipm.portfolio;
/**
 * A class price that indicate a daily price.
 * @author 21701558
 */
public class Price {
/**
 * Attribute day which is a Day object.
 */
    private final Day day;
/**
 * Attribute value which is a float.
 */
    private final float value;

    /**
     * Return the object value.
     * @return Return the object value
     */
    public final float getValue() {
        return value;
    }
    /**
     * Return the object day.
     * @return this day object
     */
    public final Day getDay() {
        return day;
    }
    /**
     * Build a price with two parameters.
     * @param dayP the day of the price
     * @param valueP the value of the price
     */
    public Price(final Day dayP, final float valueP) {
        this.day = dayP;
        this.value = valueP;
    }
}
