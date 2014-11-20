package tax;

public class Customer{
   public String name;	
   public double grossIncome;	
   
   public void applyTaxCalcFunction(TaxFunction taxFunc) {
	 
	  double calculatedTax = taxFunc.calcTax(grossIncome); 
	  System.out.println( "The calculated tax for " + name + " is "+ calculatedTax );
	 
   }
}