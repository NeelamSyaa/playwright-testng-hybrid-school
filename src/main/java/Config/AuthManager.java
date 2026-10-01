package Config;

import com.microsoft.playwright.*;
import java.io.File;
import java.nio.file.Paths;

public class AuthManager {
    
    // Path where the captured session token structure is saved
    private static final String STORAGE_STATE_PATH = "src/test/resources/auth/state.json";

    /**
     * Runs ONCE globally to capture the clean login authorization tokens and cookies.
     */
    public static void captureAndSaveToken() {
        File authDirectory = new File("src/test/resources/auth");
        if (!authDirectory.exists()) {
            authDirectory.mkdirs();
        }

        try (Playwright playwright = Playwright.create()) {
            // Launch a visible browser window briefly just to log in and steal the token
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Perform the baseline login actions
            page.navigate(FrameworkConfig.get("url"));
            page.locator("input[name='username']").fill(FrameworkConfig.get("Username"));
            page.locator("input[name='password']").fill(FrameworkConfig.get("password"));
            page.locator("button[type='submit']").click();

            // Wait for the login operation to settle on the fleet window map
            page.waitForURL("**/myFleet");

            // 💾 Extract and save the live authorization state payload to your file system
            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get(STORAGE_STATE_PATH)));
            System.out.println("🔒 Success: Authorization state token saved to state.json!");

            browser.close();
        } catch (Exception e) {
            System.err.println("❌ Failed to capture authorization states: " + e.getMessage());
        }
    }

    public static String getStorageStatePath() {
        return STORAGE_STATE_PATH;
    }
}
