package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FrameworkConfig {


	 private static Properties properties = new Properties();

	    static {
	        try {
	            String env = System.getProperty("env", "qa"); 
	            String configFilePath = "src/test/resources/config/" + env + ".properties";
	            FileInputStream inputStream = new FileInputStream(configFilePath);
	            properties.load(inputStream);
	        } catch (IOException e) {
	            System.err.println("⚠️ Could not load properties file. Using default internal mappings.");
	        }
	    }

	    public static String get(String key) {
	        // First look for the exact key requested by the code
	        String value = properties.getProperty(key);
	        if (value != null) return value.trim();

	        // 💡 Smart Fallbacks: If not found, look for your specific property file variations
	        if (key.equalsIgnoreCase("url")) {
	            value = properties.getProperty("BaseURl");
	            if (value == null) value = properties.getProperty("url");
	            return (value != null) ? value.trim() : "https://school-dev.syaa.xyz/login";
	        }
	        
	        if (key.equalsIgnoreCase("Username")) {
	            value = properties.getProperty("Username");
	            return (value != null) ? value.trim() : "9180000019";
	        }
	        
	        if (key.equalsIgnoreCase("password")) {
	            value = properties.getProperty("password");
	            return (value != null) ? value.trim() : "9180000019";
	        }

	        return value;
	    }}


