package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;
/**
 * Class of SimpleShare which is the heres of Share.
 * @author 21709520
 */
public class SimpleShare extends Share {

/**
 * HashMap of price of simple Share : Day is key and Price is value.
 */
    private Map<Day, Price> mapPrices;

/**
 * Constractor of Simple Share.
 * @param name parameter which is the identifiant of Simple Share.
 */
    public SimpleShare(final String name) {
        super(name);
        this.mapPrices = new HashMap();
    }
/**
 * Method which allowed to set the price of the simple share of the day.
 * inherit of Share.
 * @param day parameter day : day of which we want to set the price of.
 * @param value price of Simple share setted.
 */
    @Override
    public final void setPrice(final Day day, final float value) {
        if (!this.mapPrices.containsKey(day)) {
            this.mapPrices.put(day, new Price(day, value));
        }
    }
/**
 * Method which allowed to get the price of the simple share of the day.
 * inherit of Share.
 * @param day
 * @return price of the day chose.
 */
    @Override
    public final float getPrice(final Day day) {
        if (this.mapPrices.containsKey(day)) {
            return this.mapPrices.get(day).getValue();
        } else {
            return 0.0F;
        }
    }
}
