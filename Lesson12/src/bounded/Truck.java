package bounded;

import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as a container of products and its 
 * T is a parameterized type that can be placed in Truck
 */
public class Truck<T> {
	
	private ArrayList<T> products = new ArrayList<>();
	
	// load the product on the truck
	public  void add (T t){
		products.add(t);
	}
	
	// Return products loaded on the truck
	public List<T> getProducts(){
		return products;
	}
}
