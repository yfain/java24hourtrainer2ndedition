import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException; 
import java.util.Date;

class Employee2 implements Externalizable {
       String lName;
       String fName;
       String address;
       Date hireDate;
       int id;
       double salary;
       
       
   public Employee2 (){
	  
   }
   
   public void writeExternal(ObjectOutput stream)
                               throws java.io.IOException {
    // Serializing only the salary and id
    stream.writeDouble(salary);
    stream.writeInt(id);
   }

   public void readExternal(ObjectInput stream)
                               throws java.io.IOException {
	// Read fields in the same order as they were written
	 salary = stream.readDouble(); 
     id = stream.readInt();
   }
}
