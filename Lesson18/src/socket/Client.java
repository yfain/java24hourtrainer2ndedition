package socket;

import java.io.*;
import java.net.*;

public class Client {
public static void main(java.lang.String[] args) {

 if (args.length==0){
   System.out.println("Usage: java Client Symbol");
          System.exit(-1);
 } 

  Socket clientSocket = null;
  try{
	   // Open a client socket connection
		clientSocket = new Socket("localhost", 3000);
		System.out.println("Client: " + clientSocket);
	}catch (UnknownHostException uhe){
	    System.out.println("UnknownHostException: " + uhe);
	} catch (IOException ioe){
	   System.err.println("IOException: " + ioe);
   }	
	 
   try (OutputStream outbound = clientSocket.getOutputStream();
		BufferedReader inbound = new  BufferedReader(new 
		InputStreamReader(clientSocket.getInputStream()));  ){
	 
	   // Send stock symbol to the server
	outbound.write((args[0]+"\n").getBytes());

	String quote;
	while (true){
		   quote = inbound.readLine();
		   if (quote.length() == 0) continue;
		   
	       if (quote.equals("End")){
               break;	
            }
	       System.out.println("Got the quote for " + args[0]+":" + quote);
	 }
   }catch (IOException ioe){
	   ioe.printStackTrace();
	}
 }
}
