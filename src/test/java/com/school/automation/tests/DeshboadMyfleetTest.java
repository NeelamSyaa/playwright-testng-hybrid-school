package com.school.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver.DriverManager;
import Config.AuthManager;
import pages.vehcielPage;

public class DeshboadMyfleetTest extends BaseTest {

	private vehcielPage vehicleModel;

    @BeforeClass
    public void setupClassSession() {
        // 🚀 Bypasses input boxes entirely! Navigates straight to your dashboard page address
        DriverManager.getPage().navigate(Config.FrameworkConfig.get("url"));
        DriverManager.getPage().waitForURL("**/myFleet");
        this.vehicleModel = new vehcielPage();
    }

    @Test
    public void vehiclemodule() {
    	vehcielPage vehciel =  new vehcielPage();
        // Directly runs the search operational queries on the live dashboard screen
    	vehciel.navigateToDashboardPage();
        String vehicelnumer = "PB65BH7019";
        vehicleModel.searchForVehicle(vehicelnumer);
        
        System.out.println("🚀 Success! Token loaded automatically. Searched for: " + vehicelnumer);
    }
}
