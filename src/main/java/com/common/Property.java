package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	Properties properties;

	/********
	 * Function Name: Property
	 *  Gherkin Statement: NA 
	 *  Degcription: This function reads the property file to read 
	 * Author: Akhil 
	 * Input Parameters : mapFile--property file name to be loaded
	 *  Output: NA
	 ************/
	public Property(String mapFile) {
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(mapFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/***********
	 * Function Name: ReadProperty 
	 * Gherkin Statement: NA
	 *  Description:This function reads the value of the property from the properties file
	 *  Author: Akhil Input
	 * Parameters : propkey--user defined logical name of the property eg : appURL,Email To etc
	 *  Output: propval-value of the property eg : pipega e
	 ************/
	public String ReadProperty(String propkey) {
		try {
			String propval = properties.getProperty(propkey);
			return propval;
		} catch (Exception e) {
			e.printStackTrace();

			return "false";
		}

	}
}