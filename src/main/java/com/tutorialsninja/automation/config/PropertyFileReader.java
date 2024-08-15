package com.tutorialsninja.automation.config;


import java.io.IOException;
import java.util.Properties;

import com.tutorialsninja.automation.util.PathHelper;



public class PropertyFileReader implements ConfigurationReader{
	//initializing config properties file here
	Properties properties = null;
	
	public PropertyFileReader() 
	{
		properties=new Properties();
		
		try
		{
			properties.load(PathHelper.getInputStreamResourcePath("/src/main/resources/ConfigurationFile/config.properties"));
		} 
		//path helper will append the the user directory
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public String getUrl() 
	{
		return properties.getProperty("url");
	}

	public String getBrowser() 
	{
		return properties.getProperty("browser");
	}

	public int getPageLoadTimeOut() 
	{
		return Integer.parseInt(properties.getProperty("PageLoadTimeOut"));
	}

	
	}
