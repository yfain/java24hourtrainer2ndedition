import java.util.Hashtable;

public class TestHashtable {
	
	public static void main(String[] args){
		
		Customer customer = new Customer("David", "Lee");
		Order order = new Order();
		Portfolio portfolio = new Portfolio();
		
		Hashtable data = new Hashtable();
		data.put("Customer", customer);
		data.put("Order",order);
		data.put("Portfolio", portfolio);
		
		// retrieving the instance of Order by the key "Order"
		Order myOrder = (Order) data.get("Order");
	}

}
