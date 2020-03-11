package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

public class ComposedShare extends Share {

    Map<SimpleShare, Float> shareBasket;

    public ComposedShare(String name) {
        super(name);
        this.shareBasket = new HashMap();
    }

    public void registerComposition(SimpleShare simpleShare, float percentage) {
        this.shareBasket.put(simpleShare, percentage);
    }

    @Override
    public float getPrice(Day day) {
        float value;

        value = 0;
        for (SimpleShare simpleShare : this.shareBasket.keySet()) {
            value = value + (simpleShare.getPrice(day) * this.shareBasket.get(simpleShare));
        }

        return value;
    }

}
