import java.io.*;
class ClassB {
 
  public static void main(String args[]){
       
    try ( FileInputStream fIn = new  FileInputStream("BestEmployee.ser");
    	 ObjectInputStream oIn = new ObjectInputStream(fIn);){
    		 
    	 Employee bestEmp=(Employee)oIn.readObject();
     
   }catch (ClassNotFoundException cnf){
	   cnf.printStackTrace();
   } catch (IOException e){
	 e.printStackTrace();
   }
   
   System.out.println("The Employee  object has been deserialized.");
  } 
}