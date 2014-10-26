import java.util.ArrayList;
import java.util.List;


public class TestGenericCollection {

	public static void main(String[] args) {
		
		List<Customer> customers = new ArrayList<>();
		
		Customer customer1 = new Customer("David","Lee");
		customers.add(customer1);
		Customer customer2 = new Customer("Ringo","Starr");
		customers.add(customer2);
		
		//Order order= new Order();
		//customers.add(order); // Compiler error
		
		// Iterate through the list customers and do something with each 
		// element of this collection. No casting required. 
		processData(customers);
        
	}

	private static void processData(List<Customer> customers) {
		for (Customer c: customers){
			c.doSomething();
		}
	}
	 
}
