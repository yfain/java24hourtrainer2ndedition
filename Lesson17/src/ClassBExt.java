import java.io.*;
import java.util.Date;

public class ClassBExt {

  public static void main(String[] args) {
	  
	  try (FileInputStream fIn= new FileInputStream("NewEmployee2.ser");
	       ObjectInputStream oIn = new ObjectInputStream(fIn);){

		  Employee2 emp = new Employee2();
		  emp.readExternal(oIn);
		  
		  System.out.println("Deserialized employee with id " + emp.id); 
		  System.out.printf("salary = $%7.2f", emp.salary); // format as dollars
	  }catch (IOException e){
		  e.printStackTrace();
	  }
	  
  }
}
