/**
 * 
 */
package com.stockers.digital.driver;

import java.util.Scanner;

import com.stockers.digital.model.Company;
import com.stockers.digital.model.Stock;
import com.stockers.digital.model.Stockers;
import com.stockers.digital.service.StockersService;
import com.stockers.digital.service.impl.StockersServiceImpl;

/**
 * @author Parthiban Ilango
 *
 */
public class StockersDriver {

	private final static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		StockersDriver driver = new StockersDriver();

		boolean displayMenu = true;

		Stockers stockers = driver.getStockPriceDetailsFromUser();

		if (stockers != null) {
			do {
				int choice = displayMenuAndGetChoice();
				displayMenu = driver.executeServiceMethods(displayMenu, choice, stockers);
			} while (displayMenu);
		} else {
			System.out.println("Please input today's stock price and status details");
		}

	}

	private boolean executeServiceMethods(boolean displayMenu, int choice, Stockers stockers) {
		StockersService service = new StockersServiceImpl();

		switch (choice) {
		case 0:
			System.out.println("Exited From Application");
			displayMenu = false;
			break;
		case 1:
			service.getCompanies(stockers, true);
			System.out.println("Stock prices in ascending order are :");
			displayPrice(stockers.getCompanies());
			break;
		case 2:
			service.getCompanies(stockers, false);
			System.out.println("Stock prices in descending order are :");
			displayPrice(stockers.getCompanies());
			break;
		case 3:
			int noOfCompaniesRise = service.getNumberOfAssociatedCompanies(stockers, true);
			System.out.println("Total no of companies whose stock price rose today :"+noOfCompaniesRise);
			break;
		case 4:
			int noOfCompaniesDeclined = service.getNumberOfAssociatedCompanies(stockers, false);
			System.out.println("Total no of companies whose stock price declined today :"+noOfCompaniesDeclined);
			break;
		case 5:
			System.out.println("Enter the key value");
			double keyValue = sc.nextDouble();
			if(service.searchStockPrice(stockers, keyValue)) {
				System.out.println("Stock of value "+keyValue+" is present");
			}else {
				System.out.println("Value not found");
			}
			
			break;
		default:
			System.out.println("Please enter correct choice");
		}
		return displayMenu;
	}

	private void displayPrice(Company[] companies) {
		for (int i = 0; i < companies.length; i++) {
			System.out.print(companies[i].getStock().getCurrentPrice() + " ");
		}
		System.out.println("");
	}

	private Stockers getStockPriceDetailsFromUser() {
		System.out.println("Enter the no of companies");
		return createStockers(sc.nextInt());
	}

	private Stockers createStockers(int noOfCompanies) {
		Stockers stockers = new Stockers(noOfCompanies);
		for (int i = 0; i < noOfCompanies; i++) {
			int count = i + 1;
			System.out.println("Enter current stock price of the company " + count);
			double price = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?  true or false");
			boolean changePriceStatus = sc.nextBoolean();
			Company company = createCompany(price, changePriceStatus);
			stockers.getCompanies()[i] = company;
		}
		return stockers;
	}

	private Company createCompany(double price, boolean changePriceStatus) {
		Company company = new Company();
		company.setStock(createStock(price, changePriceStatus));
		return company;
	}

	private Stock createStock(double price, boolean changePriceStatus) {
		Stock stock = new Stock();
		stock.setCurrentPrice(price);
		stock.setChangeInPricePositive(changePriceStatus);
		return stock;
	}

	private static int displayMenuAndGetChoice() {
		
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");
		System.out.println("-----------------");
		return sc.nextInt();

	}

}
