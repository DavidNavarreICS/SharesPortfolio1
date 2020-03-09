package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;
/**
 * uuuiuiiiiiii
 * @author 21709520
 */
public class ComposedShare extends Share {

    Map<SimpleShare, Float> sharesBasket;

    public ComposedShare(String name) {
        super(name);
        this.sharesBasket = new HashMap();
    }

    public void registerComposition(SimpleShare simpleShare, float percentage) {
        this.sharesBasket.put(simpleShare, percentage);
    }
    /**
     * Method allowed to get a price of a share.
     * @param day day is a date of which we want to get the price of.
     * @return price of a share of one day.
     */
    @Override
    public final float getPrice(final Day day) {
        float value;

        value = 0;
        for (SimpleShare simpleShare : this.sharesBasket.keySet()) {
            value = value + (simpleShare.getPrice(day)
                    * this.sharesBasket.get(simpleShare));
        }

        return value;
    }
    /**
     * Method allowed to set a price of a share for one day.
     * @param day day is a date of which we want to set the price of.
     * @param value price of a share of one day.
     */
    @Override
    public final void setPrice(final Day day, final float value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
