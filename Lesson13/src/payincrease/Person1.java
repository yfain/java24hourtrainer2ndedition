package payincrease;

import tax.TaxFunction;

public class Person1 {
	
	private String name;

	public Person1 (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean validatePayIncrease(Payable increaseFunction, int percent) {
			 
         boolean isIncreaseValid= increaseFunction.increasePay(percent); 
         	 
         System.out.println( " Increasing pay for " + name + " is " + 
        	              (isIncreaseValid? "valid.": "not valid."));
		 return isIncreaseValid;
	}
}
