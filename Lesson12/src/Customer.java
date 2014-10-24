public class Customer extends CommonData {
	private String firstName;
	private String product;

	public Customer(String fName, String lName) {
		this.firstName = fName;
		this.product = lName;
	}

	void doSomething() {
		System.out.println("Customer " + firstName + " " + product
				+ ". In doSomething()");
	}
}
