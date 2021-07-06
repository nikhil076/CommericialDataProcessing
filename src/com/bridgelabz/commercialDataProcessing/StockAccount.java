package com.bridgelabz.commercialDataProcessing;

import java.util.LinkedList;

public class StockAccount 
{
	int noOfStockShares;
	String StockSymbol;
	double amountOfStock;

	public int getNoOfStockShares() 
	{
		return noOfStockShares;
	}
	public void setNoOfStockShares(int noOfStockShares) 
	{
		this.noOfStockShares = noOfStockShares;
	}
	public String getStockSymbol() 
	{
		return StockSymbol;
	}
	public void setStockSymbol(String stockSymbol) 
	{
		StockSymbol = stockSymbol;
	}
	
	public double getAmountOfStock() 
	{
		return amountOfStock;
	}
	public void setAmountOfStock(double amountOfStock) 
	{
		this.amountOfStock = amountOfStock;
	}
	
	@Override
	public String toString() 
	{
		return "StockAccount [noOfStockShares=" + noOfStockShares + ", StockSymbol=" + StockSymbol + ", amountOfStock="
				+ amountOfStock + "]";
	}

	LinkedList<CompanyShares> companyList = new LinkedList<>();
	
	//to add company share details
	void addCompanyShares(CompanyShares companyName)
	{
		companyList.add(companyName);
	}

	//add shares of stock to account
	void buy(int noOfStocks,String symbol)
	{
		for (CompanyShares companyShares : companyList) 
		{
			if(companyShares.getStockSymbol().equals(symbol))
			{
				if(noOfStocks<companyShares.getNumOfCompanyShares())
				{
					System.out.println("Data :"+companyShares);
					noOfStockShares = noOfStockShares + noOfStocks;
					companyShares.numOfCompanyShares= companyShares.numOfCompanyShares - noOfStocks;
					amountOfStock = noOfStocks * companyShares.getSharePrice();
					System.out.println("The number of stocks bought for company "+companyShares.getStockSymbol() + " is "+noOfStocks+" and Amount is : "+amountOfStock);
					System.out.println("Updated data :"+companyShares);

				}
				else
					System.out.println("Not Enough company shares available");
			}
			else
				System.out.println("Invalid Company Symbol");
		}
	}
	// to sell the stock 
	void sell(int noOfStocks,String symbol)
	{
		for (CompanyShares companyShares : companyList) 
		{
			if(companyShares.getStockSymbol().equals(symbol))
			{
				if(noOfStockShares>noOfStocks)
				{
					System.out.println("Data :"+companyShares);
					noOfStockShares = noOfStockShares-noOfStocks;
					System.out.println("Remaining stock for "+companyShares.getStockSymbol()+" is "+noOfStockShares);
					companyShares.numOfCompanyShares = companyShares.numOfCompanyShares + noOfStocks;
					System.out.println("Updated Data: "+companyShares);
				}
				else
					System.out.println("Not Enough shares available to sell");
			}
			else
				System.out.println("Invalid Company Symbol");
		}
	}
	//To print the report
	void printReport()
	{
		for (CompanyShares companyShares : companyList) {
			System.out.println(companyShares);
		}
	}
}
