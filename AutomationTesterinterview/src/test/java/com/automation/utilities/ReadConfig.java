package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configrations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			//loading all configurations of properties file to java class
			pro.load(fis);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is: "+e.getMessage());
		}
	}
	
	//following methods provides the required values as specified by the methods
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
		
	public String getChromepath()
	{
		String path=pro.getProperty("chromepath");
		return path;
	}
	
	public String getFirefoxpath()
	{
		String path=pro.getProperty("firefoxpath");
		return path;
	}
	
	public String getCity()
	{
		return pro.getProperty("city");
	}
	
	public String getCountry()
	{
		return pro.getProperty("country");
	}
	
	public String getInDate()
	{
		return pro.getProperty("inDate");
	}
	
	public String getOutDate()
	{
		return pro.getProperty("outDate");
	}
	
	public String getNoOfAdult()
	{
		return pro.getProperty("noOfAdult");
	}
	
	public String getNoOfRoom()
	{
		return pro.getProperty("noOfRoom");
	}
	
	public String getNoOfChild()
	{
		return pro.getProperty("noOfChild");
	}
	public String getNightCount()
	{
		return pro.getProperty("nightCount");
	}

	public String getchildAge()
	{
		return pro.getProperty("childAge");
	}
	
}
