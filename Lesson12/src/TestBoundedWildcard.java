import java.util.ArrayList;

public class TestBoundedWildcard {

	public static void main(String[] args) {

		CommonData customer = new Customer("David", "Lee");
		Order order = new Order();

		processData(customer);
		processData(order);

	}

	// any descendant of CommonData can be used as argument
	private static void processData(CommonData<? extends CommonData> data) {
		data.doSomething();
	}
}
