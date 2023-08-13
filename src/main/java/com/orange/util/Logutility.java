package com.orange.util;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Logutility {
	public static Logger log=Logger.getLogger("Logutility");
	
	public static void info(String message) {
		PropertyConfigurator.configure(".\\log4j\\Log4j.properties");
		log.info(message);
	}
	

}
