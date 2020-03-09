package fr.ut1c.m2ipm.portfolio;

import java.util.HashMap;
import java.util.Map;

/**
 * Portfolio including the shares and their quantities.
 *
 * @author yeping
 */
public final class Portfolio {

    /**
     * The key is the share,the value is one line who describes this share.
     */
    private final Map<Share, PortfolioLine> mapLines;

    /**
     * get attribut mapLines.
     *
     * @return A Map<Share,PortfolioLine>
     */
    public Map<Share, PortfolioLine> getMapLines() {
        return mapLines;
    }

    /**
     * Build a empty portfolio.
     */
    public Portfolio() {
        this.mapLines = new HashMap();
    }

    /**
     * Buy a share by specifing the share and quantity to buy.
     *
     * @param shareToBuy a share objet to buy
     * @param quantityToBuy the integer quantity should be strictly positive
     */
    public void buy(final Share shareToBuy, final int quantityToBuy) {
        if (quantityToBuy == 0) {
            throw new IllegalArgumentException("Quantity must larger than 0");
        }
        if (!this.mapLines.containsKey(shareToBuy)) {
            this.mapLines.put(shareToBuy,
                    new PortfolioLine(shareToBuy, quantityToBuy));
        } else {
            this.mapLines.get(shareToBuy).
                    setQuantity(this.mapLines.get(shareToBuy).
                            getQuantity() + quantityToBuy);
        }
    }

    /**
     * Sell the enter quantity of the share specified.
     *
     * @param sToSell a share object to sell, should exist in portfolio
     * @param qteToSell Quantity to sell, should be less or equal to existing
     * quantity.
     */
    public void sell(final Share sToSell, final int qteToSell) {
        if (this.mapLines.containsKey(sToSell)) {
            if (this.mapLines.get(sToSell).getQuantity() > qteToSell) {
                int currQte = this.mapLines.get(sToSell).getQuantity();
                int newQte = currQte - qteToSell;
                this.mapLines.get(sToSell).setQuantity(newQte);
            } else if (this.mapLines.get(sToSell).getQuantity() == qteToSell) {
                this.mapLines.remove(sToSell);
            }
        }
    }

    @Override
    public String toString() {
        return this.mapLines.toString();
    }

    /**
     * Return the value of the portfolio in a specified day.
     *
     * @param unJour the day to get the value of the portfolio
     * @return the total value of the portfolio of the specified day in float
     */
    public float getValue(final Day unJour) {
        float total = 0;
        for (PortfolioLine lp : this.mapLines.values()) {
            total += (lp.getQuantity()
                    * lp.getShare().getPrice(unJour));
        }
        return total;
    }

    /**
     * this class defines the line of the portfolio.
     */
    public class PortfolioLine {

        /**
         * the share of this line.
         */
        private final Share share;
        /**
         * the quantity of the share in this line.
         */
        private int quantity;

        /**
         * build a portfolio line using a share and its quantity.
         *
         * @param shareInit the share to add of this portfolioline
         * @param qte the quantity of the share, strictly larger than 0
         */
        PortfolioLine(final Share shareInit, final int qte) {
            this.share = shareInit;
            this.quantity = qte;
        }

        /**
         * get the quantity of the share of this line.
         *
         * @return integer that indicates the quantity of the share
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * set a quantity of the share in this line.
         *
         * @param qteToSet the quantity to set for the share, strictly larger
         * than 0
         */
        public void setQuantity(final int qteToSet) {
            this.quantity = qteToSet;
        }

        /**
         * return the share of this line.
         *
         * @return a share object of this portfolioline
         */
        public Share getShare() {
            return this.share;
        }

        @Override
        public String toString() {
            return Integer.toString(quantity);
        }
    }
}
