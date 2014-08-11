public class Order {
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
}
