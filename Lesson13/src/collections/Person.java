package collections;

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
}
