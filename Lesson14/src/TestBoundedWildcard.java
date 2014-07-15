 import java.util.ArrayList;


public class TestBoundedWildcard {

	public static void main(String[] args) {

		CommonData cust = new Customer("David","Lee");		
		Order ord= new Order();
		
		processData(cust);
		processData(ord);
        
	}
	
    // any descendant of CommonData can be used as argument 
	private static void processData(CommonData<? extends CommonData> data) {

			 data.doSomething();
	}
}
