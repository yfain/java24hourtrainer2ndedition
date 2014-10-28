package payincrease;

import tax.TaxFunction;

public class Person {
	
	private String name;
	private char workerStatus;  // 'E' or 'C'

	public Person (String name, char workerStatus){
		this.name = name;
		this.workerStatus=workerStatus;
	}
	
	public String getName(){
		return name;
	}
	
	public char getWorkerStatus(){
		return workerStatus;
	}
	
	public boolean validatePayIncrease(Payable increaseFunction, int percent) {
			 
         boolean isIncreaseValid= increaseFunction.increasePay(percent); 
         	 
         System.out.println( " Increasing pay for " + name + " is " + 
        	              (isIncreaseValid? "valid.": "not valid."));
		 return isIncreaseValid;
	}
}
