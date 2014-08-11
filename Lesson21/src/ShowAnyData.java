// Class ShowAnyData displays any data using the 
// SQL Select provided from the command line
// Enclose the SQL statement in "" in command line

import java.sql.*;

class ShowAnyData {

  public static void main(String args[]) {

   if (args.length==0){
     System.out.println("Usage: java ShowAnyData SQLSelectStatement");
     System.out.println("For example: java ShowAnyData \"Select * from Employee\"");
     System.exit(1);
   }

   
   try (Connection conn = DriverManager.getConnection( "jdbc:derby://localhost:1527/Lesson21");
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(args[0]);) {    

    // Find out the number of columns, their names and display the data
    ResultSetMetaData rsMeta = rs.getMetaData();
    int colCount = rsMeta.getColumnCount();

     for (int i = 1; i <= colCount; i++)  {
      System.out.print(rsMeta.getColumnName(i) + " "); 
    }
    System.out.println();
   
    while (rs.next()){ 
       for (int i = 1; i <= colCount; i++)  {
         System.out.print(rs.getString(i) + " "); 
       }
       System.out.print("\n");   // new line character
    }

   } catch( SQLException se ) {
      System.out.println ("SQLError: " + se.getMessage ()
           + " code: " + se.getErrorCode ());

   } catch( Exception e ) { 
      e.printStackTrace(); 
   } 
 }
}