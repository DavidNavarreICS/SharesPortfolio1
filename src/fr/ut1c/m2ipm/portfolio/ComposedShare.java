package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for describing a composed share.
 * @author _celine_
 */
public final class ComposedShare extends Share {
    /**
     * Share Basket for describing his composition and their proporsition.
     */
    private final Map<SimpleShare, Float> sharesBasket;

    /**
     * Constructor of composed share.
     * @param aName Name of share.
     */
    public ComposedShare(final String aName) {
        super(aName);
        this.sharesBasket = new HashMap();
    }

    /**
     * Composite a composed shared.
     * @param aSimpleShare a simple share in the basket.
     * @param aPercentage  percentage of this simple share in the basket.
     */
    public void registerComposition(final SimpleShare aSimpleShare,
            final float aPercentage) {
        // total percentage must < 1
        float totalPercent = 0;
        for (Float percent : this.sharesBasket.values()) {
            totalPercent += percent;
        }

        if (totalPercent + aPercentage <= 1) {
            this.sharesBasket.put(aSimpleShare, aPercentage);
        } else {
            throw new IllegalArgumentException("Percentage not allowed.");
        }
    }
    /**
     * Method allowed to get a price of a share.
     * @param day day is a date of which we want to get the price of.
     * @return price of a share of one day.
     */
    @Override
    public float getPrice(final Day day) {
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
