package com.lesson34;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockQuotePublisher {
	
	private static Logger stockLogger = 		
			Logger.getLogger(StockQuotePublisher.class.getName());
	
	static Filter expensiveStocks = (logRecord) -> {
	   	Object[] parameters = logRecord.getParameters();
	   	
	   	double price = ((Double)parameters[0]).doubleValue();
	    
	   	return 	( price > 60) ? true: false;	   	
	};
	
	public static void main(String args[]){
		
		stockLogger.setFilter(expensiveStocks);
		
		getPrice("IBM");
		getPrice("MSFT");
		getPrice("AAPL");
		getPrice("CAT");
		getPrice("VZ");
    }
	
	private static double getPrice(String stockSymbol){
		
		double price = Math.random()*100;
		stockLogger.log(Level.INFO, stockSymbol + ":" + price, price);
		
		return price;
	}
}
