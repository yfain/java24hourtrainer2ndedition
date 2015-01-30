package com.lesson34;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloConsoleHandler {
	
	private static Logger logger = 
			Logger.getLogger("com.lesson34.helloconsolehandler");

	public static void main(String[] args) {
		
		logger.setLevel(Level.FINE);
		
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		
		logger.fine("Hello fine world!");
		logger.info("Hello info world!");
		logger.severe("Hello severe world!");
	}
}
