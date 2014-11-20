import tax.Customer;
import tax.TaxFunction;


public class TestTaxLambda {

	public static void main(String[] args) {
		
		// Define one function as a lambda expression
		// and store it in a variable
		TaxFunction taxFunction = (double grossIncome) -> {
			
			double federalTax=0;
	        if (grossIncome < 30000) {
	          federalTax=grossIncome*0.05;
	        }
	        else{
	          federalTax= grossIncome*0.06;
	        }
	        return federalTax;
		};
	
		// Define another function as a lambda expression
		// for calculating tax for mafia members
		TaxFunction taxFunctionMafia = (double grossIncome) -> {
			
			double stateTax=0;
	        if (grossIncome < 30000) {
	          stateTax=grossIncome*0.01;
	        }
	        else{
	          stateTax= grossIncome*0.02;
	        }
	        return stateTax;    
		};

		Customer customer1 = new Customer();
		customer1.name = "Mary Lou";
		customer1.grossIncome=50000;
		customer1.applyTaxCalcFunction(taxFunction);

		Customer customer2 = new Customer();
		customer2.name = "Al Capone";
		customer2.grossIncome=25000;
		customer2.applyTaxCalcFunction(taxFunctionMafia);
	}
}
