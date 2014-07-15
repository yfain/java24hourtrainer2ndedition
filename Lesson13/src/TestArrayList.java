import java.util.ArrayList;

public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList customers = new ArrayList();
		Customer cust1 = new Customer("David","Lee");
		customers.add(cust1);
		Customer cust2 = new Customer("Ringo","Starr");
		customers.add(cust2);
		
		Order ord = new Order();
		customers.add(ord);
		
		int totalElem = customers.size(); // number of elements
		
		// This loop will throw ClassCastException 
		// on the third iteration
		for (int i=0; i< totalElem;i++){
		  Customer currentCust = (Customer) customers.get(i);
		  
		}

	}

}
