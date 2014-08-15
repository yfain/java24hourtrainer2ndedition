import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List customers = new ArrayList();
        Customer customer1 = new Customer("David", "Lee");
        customers.add(customer1);
        Customer customer2 = new Customer("Ringo", "Starr");
        customers.add(customer2);

        Order order = new Order();
        customers.add(order);

        // This loop will throw ClassCastException on the third iteration
        for (int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = (Customer) customers.get(i);
        }

    }

}
