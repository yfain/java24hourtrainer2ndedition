package client;

import java.net.MalformedURLException;
import java.rmi.*;

import server.StockServer;

public class Client {

  public static void main (String args[]) {

   if (args.length == 0) {
     System.out.println("\nUsage: java -Djava.security.policy=security.policy Client AAPL");
     System.exit(0);
   }


    try {  
    //  if (System.getSecurityManager() == null) {
    //     System.setSecurityManager(new  RMISecurityManager());
     // }
      StockServer myServer = (StockServer) 
        Naming.lookup("rmi://localhost:1099/QuoteService");

      String price = myServer.getQuote(args[0]);
       if  (price != null){
         System.out.println("The price of " + args[0] +
                            " is: $" + price);
       }
       else{
          System.out.println("Invalid Nasdaq symbol. " + 
             "Please use one of these:" +  
             myServer.getNasdaqSymbols().toString());
      } 
   
    } catch (MalformedURLException ex) { 
    	System.out.println(ex.getMessage()); 
    }catch (RemoteException ex2) { 
    	System.out.println(ex2.getMessage()); 
    } catch (NotBoundException e) {
		e.printStackTrace();
	}
  }
}
