package pages;

import com.microsoft.playwright.Locator;
import Config.ConfigManager;

public class LoginPage extends BasePage {
    
    // Define the three element storage fields
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;

    public LoginPage() {
        super(); 
        
        // Map elements directly using your clean attributes
        this.usernameField = page.locator("input[name='username']");
        this.passwordField = page.locator("input[name='password']");
        this.loginButton = page.locator("button[type='submit']"); 
    }

    // Opens the browser and goes to your school application portal link
    public void navigateToLoginPage() {
      
        page.navigate(ConfigManager.getBaseUrl());
    }

    // Simple interaction steps: Type user data, type secret key, submit form
    public void login(String username, String password) {
        usernameField.fill(username);
        passwordField.fill(password);
        loginButton.click();
    }
}
