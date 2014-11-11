package bounded;

public class TestGenericType {

	public static void main(String[] args) {

		Truck<Product> shipment = new Truck<>();
		
		Bike bike = new Bike();
		Wheel wheel = new Wheel();
		Person person = new Person();
		
		shipment.add(bike);		
		shipment.add(wheel);		
//		shipment.add(person); // Compiler error		
				
	}
}
