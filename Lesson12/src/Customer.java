public class Customer extends CommonData {
	private String firstName;
	private String lastName;

	public Customer(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}

	void doSomething() {
		System.out.println("Customer " + firstName + " " + lastName
				+ ". In doSomething()");
	}
}
