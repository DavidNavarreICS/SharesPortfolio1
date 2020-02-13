/*
 * Portfolio, open source software.
 * Copyright (C) 2014-2019 M2 MIAGE IPM
 * mailto:navarre@irit.fr
 *
 * Portfolio is free software; you can redistribute it and/or
 * modify it under the terms of any License.
 *
 * Portfolio is distributed in the hope that it will be useless,
 * but WITHOUT ANY WARRANTY.
 */
package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Composed share represent a set of Shares.
 *
 * @see AbstractShare
 * @author navarre
 */
public class ComposedShare extends AbstractShare {

    /**
     * A map that stores simple shares and their rate within this composed
     * share.
     */
    private final Map<SimpleShare, Float> sharesBasket;

    /**
     * Build a composed share.
     *
     * @param name is a non null string
     */
    public ComposedShare(final String name) {
        super(name);
        this.sharesBasket = new HashMap<>();
    }

    /**
     * Register a simple share within a composed share according to a rate.
     *
     * @param simpleShare the simple share to store
     * @param percentage the corresponding rate
     */
    public final void registerComposition(
            final SimpleShare simpleShare,
            final float percentage) {
        this.sharesBasket.put(simpleShare, percentage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final float getPrice(final Day day) {
        double value;

        value = 0;
        for (Map.Entry<SimpleShare, Float> simpleShare
                : this.sharesBasket.entrySet()) {
            value += ((double) simpleShare.getKey().getPrice(day)
                    * (double) simpleShare.getValue());
        }

        return (float) value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComposedShare other = (ComposedShare) obj;
        return Objects.equals(this.sharesBasket, other.sharesBasket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        return super.hashCode();
    }

}
