package pages;

import com.microsoft.playwright.Page;
import driver.DriverManager;

public class BasePage {
    protected Page page;

    public BasePage() {
        this.page = DriverManager.getPage();
    }
}
