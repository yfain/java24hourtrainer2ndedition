package annotations;
import java.util.*;
import reflection.Employee;

class HRBrowser{
	 
	  @MyJDBCExecutor (sqlStatement="Select * from Employee")
	  public List<Employee> getEmployees(){
		  // Generate the code to get the the data from DBMS,
		  // place them in ArrayList and return them to the 
		  // caller of my getEmployees
		  		  return new ArrayList<Employee>();
		  }

	  @MyJDBCExecutor (sqlStatement="Update Employee set bonus=1000", 
			            transactionRequired=true, 
			            notifyOnUpdates=true)
	  
	  public void updateData(){
		  // JDBC code to perform transactional updates  and
		  // notifications goes here
		  }
	}
