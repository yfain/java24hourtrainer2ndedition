package tax;

import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TaxCommandLineRunner {

	public static void main(String[] args) {
		
		JUnitCore junitCore = new JUnitCore();
		
		Result result = junitCore.run(AllTests.class);
		
		if (result.wasSuccessful()){
			
		  System.out.println("All Tax Test cases ran successfully");
	
			
		} else{
			
		  System.out.println("These Tax Test cases failed:");
		  List<Failure> failedTests = result.getFailures();
		  failedTests.forEach(failure ->
		        System.out.println(failure.getMessage()));	

		}
		
	}
}
