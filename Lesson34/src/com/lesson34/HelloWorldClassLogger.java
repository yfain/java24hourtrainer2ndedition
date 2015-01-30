package com.lesson34;

import java.util.logging.Logger;

public class HelloWorldClassLogger {
	
	//private static Logger helloLogger = 
	//		Logger.getLogger("com.lesson34.HelloWorldClassLogger");
	
	private static Logger helloLogger = 		
			Logger.getLogger(HelloWorldClassLogger.class.getPackage().getName());
	
	public static void main(String[] args) {
		
		helloLogger.info("Trying to divide by zero");
		try{
			int result = 25/0;
		} catch(ArithmeticException e){
			helloLogger.severe("Division by zero");	
		}
		
	}
}
