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
 * @param day parameter day : day of which we want to set the price of.
 * @param value price of Simple share setted.
 */
    @Override
    public void setPrice(Day day, float value) {
        if (!this.mapPrices.containsKey(day)) {
            this.mapPrices.put(day, new Price(day, value));
        }
    }
/**
 * 
 * @param day
 * @return 
 */
    @Override
    public float getPrice(Day day) {
        if (this.mapPrices.containsKey(day) == true) {
            return this.mapPrices.get(day).getValue();
        } else {
            return 0.0F;
        }
    }
}
