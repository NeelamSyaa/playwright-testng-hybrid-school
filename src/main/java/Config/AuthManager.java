package Config;

import java.nio.file.Paths;
import com.microsoft.playwright.*;

public class AuthManager {
    
   
    private static final String FILE_PATH = "src/test/resources/auth/state.json";

    public static void captureAndSaveToken() {
        
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

     
        page.navigate(FrameworkConfig.get("BaseURl"));
        page.locator("input[name='username']").fill(FrameworkConfig.get("Username"));
        page.locator("input[name='password']").fill(FrameworkConfig.get("password"));

        // 4. Click the submit login button
        page.locator("button[type='submit']").click();

     
        // 6. Save the active login session context straight into your file target
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get(FILE_PATH)));
        System.out.println("Login session saved successfully to state.json!");

      
        browser.close();
        playwright.close();
    }

    
    public static String getStorageStatePath() {
        return FILE_PATH;
    }
}
