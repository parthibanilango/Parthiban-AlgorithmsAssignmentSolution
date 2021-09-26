/**
 * 
 */
package com.stockers.digital.model;

/**
 * This class holds stock related details
 * @author Parthiban Ilango
 *
 */
public class Stock {
	
	private double currentPrice;
	
	private boolean changeInPricePositive;

	

	/**
	 * @return the currentPrice
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * @param currentPrice the currentPrice to set
	 */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
	 * @return the changeInPricePositive
	 */
	public boolean isChangeInPricePositive() {
		return changeInPricePositive;
	}

	/**
	 * @param changeInPricePositive the changeInPricePositive to set
	 */
	public void setChangeInPricePositive(boolean changeInPricePositive) {
		this.changeInPricePositive = changeInPricePositive;
	}

}
