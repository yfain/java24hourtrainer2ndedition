import java.util.Hashtable;

public class TestHashtable {
	
	public static void main(String[] args){
		
		Customer cust = new Customer("David", "Lee");
		Order ord = new Order();
		Portfolio port = new Portfolio();
		
		Hashtable data = new Hashtable();
		data.put("Customer", cust);
		data.put("Order",ord);
		data.put("Portfolio", port);
		
		// retrieving the instance of Order by the key "Order"
		Order myOrder = (Order) data.get("Order");
	}

}
