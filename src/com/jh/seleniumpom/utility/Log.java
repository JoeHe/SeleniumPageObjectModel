package com.jh.seleniumpom.utility;


import org.testng.log4testng.Logger;

public class Log {
	private static final Logger LOGGER = Logger.getLogger(Log.class);
	
	public static void INFO(String str){
		LOGGER.info(str);
	}
	
	public static void WARN(String str){
		LOGGER.warn(str);
	}
}
