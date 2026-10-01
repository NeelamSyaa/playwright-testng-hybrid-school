package driver;

import java.nio.file.Paths;
import com.microsoft.playwright.*;
import Config.ConfigManager;
import Config.AuthManager;

public class DriverManager {
    
   
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

   
    public static Page getPage() {
        return page;
    }

    
    public static void initDriver() {
        
        playwright = Playwright.create();

     
        boolean isHeadless = Boolean.parseBoolean(ConfigManager.getHeadless());
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));

        context = browser.newContext(new Browser.NewContextOptions()
            .setStorageStatePath(Paths.get(AuthManager.getStorageStatePath())));

        page = context.newPage();
    }

   
    public static void quitDriver() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
