package com.stockers.digital.model;

/**
 * @author Parthiban Ilango
 *
 */
public class Stockers {
	
	private int totalAssociatedCompany;
	
	private int totalGainersToday;
	
	private int totalLosersToday;
	
	private Company[] companies;
	
	public Stockers(int totalAssociatedCompany) {
		this.totalAssociatedCompany = totalAssociatedCompany;
		this.companies = new Company[totalAssociatedCompany];
	}

	/**
	 * @return the totalAssociatedCompany
	 */
	public int getTotalAssociatedCompany() {
		return totalAssociatedCompany;
	}

	/**
	 * @param totalAssociatedCompany the totalAssociatedCompany to set
	 */
	public void setTotalAssociatedCompany(int totalAssociatedCompany) {
		this.totalAssociatedCompany = totalAssociatedCompany;
	}

	/**
	 * @return the companies
	 */
	public Company[] getCompanies() {
		return companies;
	}

	/**
	 * @return the totalGainersToday
	 */
	public int getTotalGainersToday() {
		return totalGainersToday;
	}

	/**
	 * @param totalGainersToday the totalGainersToday to set
	 */
	public void setTotalGainersToday(int totalGainersToday) {
		this.totalGainersToday = totalGainersToday;
	}

	/**
	 * @return the totalLosersToday
	 */
	public int getTotalLosersToday() {
		return totalLosersToday;
	}

	/**
	 * @param totalLosersToday the totalLosersToday to set
	 */
	public void setTotalLosersToday(int totalLosersToday) {
		this.totalLosersToday = totalLosersToday;
	}

}
