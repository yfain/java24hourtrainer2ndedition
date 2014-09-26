package server;

import java.rmi.*;
import java.rmi.server.*;      
import java.util.ArrayList;

public class StockServerImpl extends UnicastRemoteObject  implements StockServer {
  private String price=null;
  private ArrayList<String> nasdaqSymbols = new ArrayList<String>();

  public StockServerImpl() throws RemoteException {
    super();
   
    // Define some hard-coded NASDAQ symbols 
    nasdaqSymbols.add("AAPL");
    nasdaqSymbols.add("MSFT");
    nasdaqSymbols.add("YHOO");
    nasdaqSymbols.add("AMZN");
    nasdaqSymbols.add("MOT");
  }

  public String getQuote(String symbol)
                          throws RemoteException {

	  
    if(nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {

        // Generate a random price for valid symbols   
        price = (new Double(Math.random()*100)).toString();
    }
    
    //This version of the code doesn't process the case if the client
    // doesn't specify a valid stock symbol - it just returns the value
    // currently stored in the variable price
    return price;
  }

  public ArrayList<String> getNasdaqSymbols()throws RemoteException {
    return nasdaqSymbols;
  }  
}

