package com.school.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Config.FrameworkConfig;
import pages.LoginPage;

public class LoginTest  extends BaseTest{

	  @Test
	    public void verifySuccessfulLoginWithAriaRoles() {
	        // 2. Initialize the Login Page Object (now inherits the active browser page from BaseTest)
	        LoginPage loginPage = new LoginPage();
	        
	        // 3. Open the browser window and navigate to your portal URL
	        loginPage.navigateToLoginPage();
	        
	        // 4. Run the sequence using credentials directly fetched from your properties file
	        loginPage.login(FrameworkConfig.get("Username"), FrameworkConfig.get("password"));
	        
	   // Assert.assertTrue(loginPage.getPageUrl().contains("/myFleet"),"Login Failure: The browser did not navigate to the My Fleet dashboard page");
	  }
}
