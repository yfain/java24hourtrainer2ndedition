package lesson34;
public class Stock {

    public Stock(String symbol, String quote) {
        this.symbol = symbol;
        this.quote = quote;
    }
    private String symbol;
    private String quote;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
