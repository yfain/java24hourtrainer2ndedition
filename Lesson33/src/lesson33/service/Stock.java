package lesson33.service;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Stock {
    private String symbol;
    private Double price;
    private String currency;
    private String country;

    public Stock() {
    }

    public Stock(String symbol, Double price, String currency, String country) {
        this.symbol = symbol;
        this.price = price;
        this.currency = currency;
        this.country = country;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
