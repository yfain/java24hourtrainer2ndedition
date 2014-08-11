// Class EmployeeList displays Employees from the table EMP 
// using JDBC drivers of type 4

import java.sql.*;

class EmployeeList {

  public static void main(String argv[]) {
   
   String sqlQuery = "SELECT * from Employee"; 

   // Open autocloseable Connection, Statement and get the result set
   try (Connection conn = DriverManager.getConnection( "jdbc:derby://localhost:1527/Lesson21");
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(sqlQuery); ) {  

      // Process the result set - print Employees
      while (rs.next()){ 
    	 int empNo = rs.getInt("EMPNO");
       	 String eName = rs.getString("ENAME");
         String job = rs.getString("JOB_TITLE");
	     System.out.println(""+ empNo + ", " + eName + ", " + job ); 
      }
   } catch( SQLException se ) {
      System.out.println ("SQLError: " + se.getMessage ()
           + " code: " + se.getErrorCode ());

   } catch( Exception e ) {
      System.out.println(e.getMessage()); 
      e.printStackTrace(); 
   } 
}
}
