package Config;

public class ConfigManager {
	
    public static String getBaseUrl() {
       
        return FrameworkConfig.get("BaseURl");
    }

    public static String getBrowser() {
       
        return FrameworkConfig.get("browser");
    }

    public static String getHeadless() {
       
        return FrameworkConfig.get("headless");
    }
    
    public static String getImplicitWait() {
        return FrameworkConfig.get("impcitiwait");
    }
}
