package composition;

import java.util.ArrayList;
import java.util.List;

import polymorfism.Employee;

public class DemoPayIncreaseLambda {

  public static void main(String[] args) {

    // Lambda 1 - rules for employees
	Payable for_employees = (percent) -> {
      return true;
    };

    // Lambda 2 - rules for contractors
    Payable for_contractors = (percent) -> {
      if (percent > Payable.INCREASE_CAP) {
        return false;
      } else {
        return true;
      }
    };

    List<Person> workers = new ArrayList<>();
    // Instantiate workers passing appropriate pay increase rules
    workers.add(new Person("Peter", for_employees));
    workers.add(new Person("Mary", for_contractors));
	workers.add(new Person("Steve", for_employees));	

    for (Person worker : workers) {
      worker.tryIncrease(30);
    }

  }
}