package com.school.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver.DriverManager;
import Config.ConfigManager; // Added import
import Config.FrameworkConfig;
import pages.Driverpage;
import pages.LoginPage;
@Test(priority = 4)
public class DriverModuleTest extends BaseTest {

    private Driverpage driverModule;
    LoginPage lp;
    @BeforeClass
    public void setupClassSession() {
        // 💡 FIXED: Uses ConfigManager.getBaseUrl() to get the correct "BaseURl" value
        DriverManager.getPage().navigate(ConfigManager.getBaseUrl());
        lp =  new LoginPage();
        lp .login(FrameworkConfig.get("Username"), FrameworkConfig.get("password"));
        DriverManager.getPage().waitForURL("**/myFleet");
        
        this.driverModule = new Driverpage();
    }

    @Test
    public void verifyAddNewDriverWorkflow() {
        driverModule.clickDriversTab();
        driverModule.clickAddDriverButton();
        
        String testDriverName = "John Doe Test";
        driverModule.enterDriverDetails(testDriverName, "DL-1234567890123", "01011990", "9876543210");
        driverModule.clickFetchDetails();
        driverModule.clickSaveDriver();
        
        boolean isDriverAdded = driverModule.isDriverTextPresentInGrid(testDriverName);
        Assert.assertTrue(isDriverAdded, "Test Failed: Driver row not found in DOM!");
    }
}
