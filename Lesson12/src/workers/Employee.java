package workers;

public class Employee extends Person{

	public Employee(String name){
		super(name);
	}
	public boolean increasePay(int percent) {
			System.out.println("Increasing salary by " + percent + "%. "+ getName()); 
			return true;
	}
}
