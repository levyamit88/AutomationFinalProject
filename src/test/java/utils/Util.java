package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	public String readProperty(String key)  {
		String value = "";
		try (InputStream input = new FileInputStream("./src/test/resources/data/configuration.properties")) {
		            // read Properties object
		            Properties prop = new Properties();

		            // load a properties file
		            prop.load(input);

		         //get the property value and print it out
		         value  = prop.getProperty(key);    
		              
		        } catch (Exception e) {
		            
		        }
		      return value ;
		    }


}
