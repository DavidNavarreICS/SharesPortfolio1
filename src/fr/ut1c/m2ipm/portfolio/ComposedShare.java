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

    @Override
    public float getPrice(Day day) {
        float value;

        value = 0;
        for (SimpleShare simpleShare : this.sharesBasket.keySet()) {
            value = value + (simpleShare.getPrice(day) * this.sharesBasket.get(simpleShare));
        }

        return value;
    }

}
