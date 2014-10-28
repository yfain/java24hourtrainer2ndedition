package function;

import java.util.function.BiFunction;

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
	
   
	public boolean validateIncreasePay(BiFunction<Person, Integer, Boolean> func, int percent){
		
		boolean isIncreaseValid = func.apply(this, percent);
        System.out.println( " Increasing pay is " + 
	              (isIncreaseValid? "valid.": "not valid."));
		return isIncreaseValid;
	}
}
