package com.lesson34;

import java.util.logging.Logger;

public class HelloWorldGlobalLogger {
	
	private static Logger logger = 
			Logger.getGlobal();

	public static void main(String[] args) {
		
		logger.fine("Hello fine world!");
		logger.info("Hello info world!");
		logger.severe("Hello severe world!");
	}
}
