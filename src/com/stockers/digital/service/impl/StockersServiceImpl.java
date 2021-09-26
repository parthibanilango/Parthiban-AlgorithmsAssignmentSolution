/**
 * 
 */
package com.stockers.digital.service.impl;

import com.stockers.digital.model.Company;
import com.stockers.digital.model.Stockers;
import com.stockers.digital.service.StockersService;
import com.stockers.digital.util.StockersUtil;

/**
 * @author Parthiban Ilango
 *
 */
public class StockersServiceImpl implements StockersService {

	@Override
	public int getNumberOfAssociatedCompanies(Stockers stockers) {
		return stockers.getTotalAssociatedCompany();
	}

	@Override
	public Company[] getCompanies(Stockers stockers, boolean isStockPriceAscending) {
		StockersUtil.sort(stockers.getCompanies(),isStockPriceAscending);
		return stockers.getCompanies();
	}

	@Override
	public int getNumberOfAssociatedCompanies(Stockers stockers, boolean isStockPriceIncreasedInd) {
		
		int companyCount=0;
		for(Company company:stockers.getCompanies()) {
			if(null != company.getStock() && company.getStock().isChangeInPricePositive()== isStockPriceIncreasedInd) {
				companyCount++;
			}
		}
		return companyCount;
	}

	@Override
	public boolean searchStockPrice(Stockers stockers, double stockPrice) {
		StockersUtil.sort(stockers.getCompanies(),true);
		return searchValue(stockers.getCompanies(), stockPrice);
	}
	
	public boolean searchValue(Company[] array, double value) {

		int l = 0;

		int r = array.length - 1;

		int mid = l + (r - l) / 2;

		while (l <= r) {
			if (value < array[mid].getStock().getCurrentPrice()) {
				r = mid - 1;
			} else if (value > array[mid].getStock().getCurrentPrice()) {// range is mid+1 to r
				l = mid + 1;
			} else {
				//System.out.println("Search value " + value + "found atindex: " + mid);
				return true;
			}
			mid = l + (r - l) / 2;
		}
		if (l > r) {
			//System.out.println("Value not found");
			return false;
		}
		
		return false;
	}

}
