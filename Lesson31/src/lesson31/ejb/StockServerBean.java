package lesson31.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class StockServerBean {
	private String price = null;
	private List<String> nasdaqSymbols = new ArrayList<>();
	
	public StockServerBean(){
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("IBM");
		nasdaqSymbols.add("ORCL");
		nasdaqSymbols.add("AMZN");
	}
	
	public String getQuote(String symbol){
		
		if ((nasdaqSymbols.indexOf(symbol.toUpperCase())) != -1){
			
			price = (new Double(Math.random()*100)).toString();
		}
		//System.out.println("The price of " + symbol + " is " + price);
		return price;
	}
}
