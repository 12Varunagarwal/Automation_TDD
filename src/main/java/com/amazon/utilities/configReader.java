package com.amazon.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	private Properties prop;
	public configReader() {
		
	
		 prop = new Properties();
		 try {
			 
			 FileInputStream fis = new FileInputStream("src/test/resources/Configurations/config.properties");
			 prop.load(fis);
			 
		 }
		 
		 catch(IOException io) {
			 io.printStackTrace();
			 
		 }
	}
		 public String geturl() {
			  return prop.getProperty("url");
			 
			 
		 }
		 
		 public String getbrowser() {
			  return prop.getProperty("browser");
			 
			 
		 }
		 
		 public long getGlobalWait() {
			    return Long.parseLong(prop.getProperty("globalwait"));
			}
	}

