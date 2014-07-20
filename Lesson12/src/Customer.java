
public class Customer extends CommonData{
	private String fName;
	private String lName;
	
    public Customer (String fName, String lName){
    	this.fName=fName;
    	this.lName=lName;	
    }
    
	void doSomething(){
		System.out.println("Customer " + fName + " " +lName + ". In doSomething()");
	}
}
