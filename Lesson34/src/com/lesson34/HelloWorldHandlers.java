package com.lesson34;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorldHandlers {
	
	private static Logger helloLogger = 		
			Logger.getLogger(HelloWorldClassLogger.class.getName());
	
	public static void main(String[] args) {
		
		FileHandler helloFileHandler;
		try {
			helloFileHandler = new FileHandler("logs/helloWorld.log");
			helloLogger.addHandler(helloFileHandler);
			helloFileHandler.setLevel(Level.WARNING);
		} catch (SecurityException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		helloLogger.fine("Hello from the fine world");
		helloLogger.info("Trying to divide by zero");
		try{
			int result = 25/0;
		} catch(Exception e){
			helloLogger.severe("Division by zero");	
		}
	}
}
