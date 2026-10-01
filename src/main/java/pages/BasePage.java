package pages;

import com.microsoft.playwright.Page;

import driver.DriverManager;

public class BasePage {

	 protected Page page;

	    public BasePage() {
	        this.page = DriverManager.getPage();
	    }

	    protected void navigateTo(String url) {
	        page.navigate(url);
	    }

	    protected void click(String selector) {
	        page.locator(selector).click();
	    }

	    protected void writeText(String selector, String text) {
	        page.locator(selector).fill(text);
	    }

	    protected String getText(String selector) {
	        return page.locator(selector).textContent();
	    }
	    
	    // 💡 Added this missing method so your LoginTest can verify the landing page URL
	    public String getPageUrl() {
	        return page.url();
	    }
	}

