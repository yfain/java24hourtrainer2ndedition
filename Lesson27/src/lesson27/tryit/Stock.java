package lesson27.tryit;

import java.io.Serializable;

public class Stock implements Serializable {

	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
