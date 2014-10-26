import java.util.ArrayList;
import java.util.List;

public class TestArrayListForEach {

	public static void main(String[] args) {
		
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("David","Lee"));
		customers.add(new Customer("Ringo","Starr"));
		
		// In Java 8 you can iterate through the collection and print its elements like this:
		customers.forEach(customer-> System.out.println(customer) );	

	}

}
