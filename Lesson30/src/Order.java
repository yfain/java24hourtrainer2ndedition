import java.io.Serializable;

public class Order implements Serializable{
    public int orderID;
    public String stockSymbol;
    public int quantity;
    public float price;
    
    public Order(int id, String stockSymbol, int quantity, float price){
    	orderID=id;
    	this.stockSymbol=stockSymbol;
    	this.quantity=quantity;
    	this.price=price;
    }
    
    public String toString(){
    	return "Stock symbol: " + stockSymbol + ", quantity: "+ quantity +
    		", price: " + price;
    }
}
