/**
 * 
 */
package com.stockers.digital.service;

import com.stockers.digital.model.Company;
import com.stockers.digital.model.Stockers;

/**
 * 
 * Interface to access Stockerservice
 * @author Parthiban Ilango
 *
 */
public interface StockersService {
	
	/**
	 * @param stockers
	 * @return number of associated companies
	 */
	public int getNumberOfAssociatedCompanies(Stockers stockers);
	
	/**
	 * @param stockers
	 * @param isStockPriceAscending
	 * @return companies in ascending or descending order based on isStockPriceAscending
	 * isStockPriceAscending = true  ascending order
	 * isStockPriceAscending = false  descending order
	 */
	public Company[] getCompanies(Stockers stockers, boolean isStockPriceAscending);
	
	/**
	 * @param stockers
	 * @param isStockPriceIncreasedInd
	 * @return number of associated companies based on todays stock price indicator
	 * isChangeInPricePositive = true - companies for which share price increased today
	 * isChangeInPricePositive =false - companies for which share price decreased today
	 * 
	 */
	public int getNumberOfAssociatedCompanies(Stockers stockers, boolean isStockPriceIncreasedInd);
	
	
	/**
	 * @param stockers
	 * @param stockPrice
	 * @return
	 */
	public boolean searchStockPrice(Stockers stockers, double stockPrice);

}
