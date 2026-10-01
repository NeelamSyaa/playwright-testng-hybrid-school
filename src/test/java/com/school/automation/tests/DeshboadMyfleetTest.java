package com.school.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver.DriverManager;
import Config.ConfigManager; // Added import
import Config.FrameworkConfig;
import pages.LoginPage;
import pages.vehcielPage;
@Test(priority = 2)
public class DeshboadMyfleetTest extends BaseTest {

    private vehcielPage vehicleModel;
    LoginPage lp ;
    @BeforeClass
    public void setupClassSession() {
        // 💡 FIXED: Uses ConfigManager.getBaseUrl() to get the correct "BaseURl" value
        DriverManager.getPage().navigate(ConfigManager.getBaseUrl());
         lp =  new LoginPage();
        lp .login(FrameworkConfig.get("Username"), FrameworkConfig.get("password"));
        
        DriverManager.getPage().waitForURL("**/myFleet");
        
        this.vehicleModel = new vehcielPage();
       
        
    }

    @Test
    public void vehiclemodule() {
        String vehicelnumer = "PB65BH7019";
        vehicleModel.searchForVehicle(vehicelnumer);
        System.out.println(" Success! Searched for vehicle: " + vehicelnumer);
    }
}
