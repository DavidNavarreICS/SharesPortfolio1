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
 * Hold a set of share with associated quantities.
 *
 * @author David Navarre
 */
public final class Portfolio {

    /**
     * Collections that holds association between shares and quantities.
     */
    private final Map<AbstractShare, PortfolioLine> mapLines;
    /**
     * Error message sent when the quantity is negative or null.
     */
    private static final String QUANTITY_INCORRECT
            = "The quantity must be strictly positive";
    /**
     * Error message sent when the share object is null.
     */
    private static final String SHARE_NULL_ERROR
            = "The share cannot be null";

    /**
     * Build an empty portfolio.
     */
    public Portfolio() {
        this.mapLines = new HashMap<>();
    }

    /**
     * Adds shares to a portfolio.<br>The share is only added ones (the first
     * time) and the quantity is cumulated.
     *
     * @param share the non empty share to be added
     * @param quantity the quantity to add (&gt;0)
     */
    public void buy(final AbstractShare share, final int quantity) {
        if (Objects.isNull(share)) {
            throw new IllegalArgumentException(SHARE_NULL_ERROR);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException(QUANTITY_INCORRECT);
        }
        if (!this.mapLines.containsKey(share)) {
            this.mapLines.put(share, new PortfolioLine(share, quantity));
        } else {
            int newQuantity = this.mapLines.get(share).getQuantity() + quantity;
            this.mapLines.get(share).setQuantity(newQuantity);
        }
    }

    /**
     * Remove part of the possessed shares.<br>If the quantity excess what is
     * possessed, the share is removed.
     *
     * @param share the share to remove
     * @param quantity the quantity to remove
     */
    public void sell(final AbstractShare share, final int quantity) {
        if (Objects.isNull(share)) {
            throw new IllegalArgumentException(SHARE_NULL_ERROR);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException(QUANTITY_INCORRECT);
        }
        if (this.mapLines.containsKey(share)) {
            if (this.mapLines.get(share).getQuantity() > quantity) {
                int newQ = this.mapLines.get(share).getQuantity() - quantity;
                this.mapLines.get(share).setQuantity(newQ);
            } else {
                this.mapLines.remove(share);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.mapLines.toString();
    }

    /**
     * Provides the value of the portfolio for a given day.<br>
     * The value is computed based on each possessed shared.
     *
     * @param day a non null day
     * @return the computed value
     */
    public float getValue(final Day day) {
        double total = 0;
        for (PortfolioLine lp : this.mapLines.values()) {
            total = total
                    + ((double) lp.getQuantity()
                    * (double) lp.getShare().getPrice(day));
        }
        return (float) total;
    }

    /**
     * A utility class that holds share and associated quantity.
     */
    private static final class PortfolioLine {

        /**
         * A non null share.
         */
        private final AbstractShare share;
        /**
         * The quantity must be strictly positive.
         */
        private int quantity;

        /**
         * Build a association between a share and a strictly positive quantity.
         *
         * @param aShare the share
         * @param aQuantity a strictly positive value
         */
        PortfolioLine(final AbstractShare aShare, final int aQuantity) {
            this.share = aShare;
            this.quantity = aQuantity;
        }

        /**
         * Provides the quantity possessed of the corresponding share.
         *
         * @return the quantity possessed
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Modifies the quantity possessed.
         *
         * @param aQuantity the new value
         */
        public void setQuantity(final int aQuantity) {
            this.quantity = aQuantity;
        }

        /**
         * Gives read access to the share attribute.
         *
         * @return the non null share
         */
        public AbstractShare getShare() {
            return this.share;
        }

        /**
         * {@inheritDoc}
         */
        public String toString() {
            return Integer.toString(quantity);
        }
    }
}
