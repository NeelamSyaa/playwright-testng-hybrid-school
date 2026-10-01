package driver;

import com.microsoft.playwright.*;
import Config.ConfigManager;
import Config.AuthManager;
import java.nio.file.Paths;

public class DriverManager {
    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void initDriver() {
        Playwright playwright = Playwright.create();
        playwrightThreadLocal.set(playwright);

        String browserType = ConfigManager.getBrowser().toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(ConfigManager.getHeadless());

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));

        // 💡 INJECT SAVED TOKEN: The browser context opens pre-loaded with your active login tokens!
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setStorageStatePath(Paths.get(AuthManager.getStorageStatePath())));

        Page page = context.newPage();

        browserThreadLocal.set(browser);
        contextThreadLocal.set(context);
        pageThreadLocal.set(page);
    }

    public static void quitDriver() {
        if (pageThreadLocal.get() != null) pageThreadLocal.get().close();
        if (contextThreadLocal.get() != null) contextThreadLocal.get().close();
        if (browserThreadLocal.get() != null) browserThreadLocal.get().close();
        if (playwrightThreadLocal.get() != null) playwrightThreadLocal.get().close();

        pageThreadLocal.remove();
        contextThreadLocal.remove();
        browserThreadLocal.remove();
        playwrightThreadLocal.remove();
    }
}
