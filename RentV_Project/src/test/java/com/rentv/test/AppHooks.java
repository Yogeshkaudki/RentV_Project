package com.rentv.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;

public class AppHooks {

	FileReader reader;
	public static Properties prop;

	@Before
	public void getProperty() throws IOException {
		String userDirPath = System.getProperty("user.dir");
		reader=new FileReader(userDirPath + "src\\test\\java\\com\\rentv\\test\\ConfigProperties.properties");  	      
		prop=new Properties();  
		prop.load(reader);  
	}


}
