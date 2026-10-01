package com.school.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver.DriverManager;
import Config.AuthManager;
import Config.FrameworkConfig;
import pages.LoginPage;
import pages.vehcielPage;

public class DeshboadMyfleetTest extends BaseTest {

	private vehcielPage vehicleModel;
	private LoginPage loginPage ;
	
    @BeforeClass
    public void setupClassSession() {
       
        DriverManager.getPage().navigate(Config.FrameworkConfig.get("url"));
        DriverManager.getPage().waitForURL("**/myFleet");
        this.vehicleModel = new vehcielPage();
         loginPage = new LoginPage();
    }

    @Test
    public void vehiclemodule() throws InterruptedException {
        
    	loginPage.navigateToLoginPage();
    	loginPage.wait(10);
        loginPage.login(FrameworkConfig.get("Username"), FrameworkConfig.get("password"));
        vehicleModel.navigateToDashboardPage();
        String vehicelnumer = "PB65BH7019";
        vehicleModel.searchForVehicle(vehicelnumer);
        
        System.out.println("🚀 Success! Token loaded automatically. Searched for: " + vehicelnumer);
    }
}
