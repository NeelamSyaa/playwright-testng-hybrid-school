package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FrameworkConfig {
   

    private static Properties properties = new Properties();

    static {
        try {
        	 String configFilePath =  "C:\\Users\\Admin\\eclipse-workspace\\playwright-testng-hybrid-school\\src\\test\\resources\\config\\qa.properties";
            FileInputStream fileInput = new FileInputStream(configFilePath);
            
          
            properties.load(fileInput);
        } catch (Exception e) {
            System.out.println(" Failed to load properties file: " + e.getMessage());
        }
    }

   
    public static String get(String key) {
     
        return properties.getProperty(key);
    }}


