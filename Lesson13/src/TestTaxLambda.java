import com.practicalJava.lesson15.tax.TaxFunction;
import com.practicalJava.lesson15.tax.Customer;


public class TestTaxLambda {

	public static void main(String[] args) {
		
		// Define the function as a lambda expression
		// and store it in a variable
		TaxFunction tf = (double grossIncome, String state) -> {
			
			 double stateTax=0;
		        if (grossIncome < 30000) {
		          stateTax=grossIncome*0.05;
		        }
		        else{
		          stateTax= grossIncome*0.06;
		        }
		          return stateTax;
		};
	

		Customer customer1 = new Customer();
		customer1.name = "Mary";
		customer1.grossIncome=50000;
		customer1.state="NY";
		customer1.applyTaxCalcFunction(tf);

		Customer customer2 = new Customer();
		customer2.name = "Peter";
		customer2.grossIncome=25000;
		customer2.state="NY";
		customer2.applyTaxCalcFunction(tf);
	}
	

}
