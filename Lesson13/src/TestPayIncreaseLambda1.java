import payincrease.*;

public class TestPayIncreaseLambda1 {
	
  public static void main(String[] args) {

        Person1 workers[] = new Person1[3];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");		

	  // Lambda expression for increasing Employee's pay
	   Payable increaseRulesEmployee = (int percent) -> {
				return true;
	   };
	   
		// Lambda expression for increasing Contractor's pay	   
	    Payable increaseRulesContractor = (int percent) -> {
	    	if(percent > Payable.INCREASE_CAP){
	    		System.out.print(" Sorry, can't increase hourly rate by more than " + 
	    	             Payable.INCREASE_CAP + "%. "); 
				return false;
			} else {	
				return true;
			}
	   };	
	   
	   for (Person1 p: workers){
		   if (p instanceof Employee){
			   // Validate 30% increase for every worker
			   p.validatePayIncrease(increaseRulesEmployee, 30); 
		   } else if (p instanceof Contractor){
			   p.validatePayIncrease(increaseRulesContractor, 30);
		   }
	   }
  }

}
