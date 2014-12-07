package lesson27.tryit;

import java.util.ArrayList;
import java.util.List;

public class StockPriceGenerator {
	
	private List<String> supportedSymbols = new ArrayList<>();

	public StockPriceGenerator() {
		supportedSymbols.add("AAPL");
		supportedSymbols.add("MSFT");
		supportedSymbols.add("YHOO");
		supportedSymbols.add("AMZN");
		supportedSymbols.add("IBM");
	}

	public String getPrice(String symbol) {
		String price = "";
        
		// Check if the symbol is valid 
		if (supportedSymbols.indexOf(symbol.toUpperCase()) != -1) {
			// Generate a random price for valid symbols
			price = (new Double(Math.random() * 100)).toString();
		} else {
			price = "Not a valid symbol.Use one of these: " +
		                              getSupportedSymbols();
		}

		return price;
	}

	private String getSupportedSymbols() {
		StringBuilder symbols = new StringBuilder();
		for (String symbolName : supportedSymbols) {
			symbols.append(symbolName);
			symbols.append(" ");
		}
		return symbols.toString();
	}	
}
