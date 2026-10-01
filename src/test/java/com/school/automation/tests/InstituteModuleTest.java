package com.school.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver.DriverManager;
import Config.ConfigManager;
import pages.Institutepage;

// Set your class priority order
@Test(priority = 3)
public class InstituteModuleTest extends BaseTest {

    private Institutepage instituteModule;
    
    @BeforeClass
    public void setupClassSession() {
        // 1. Go directly to your application via your pre-built session tokens
        DriverManager.getPage().navigate(ConfigManager.getBaseUrl());
        
        // 2. Wait for the landing screen to load completely
        DriverManager.getPage().waitForURL("**/myFleet");
        
        // 💡 Fixed: Removed the extra lpi.login() commands because you are ALREADY logged in here!
        this.instituteModule = new Institutepage();
    }

    @Test
    public void verifyCreateNewInstituteWorkflow() {
        // Step 1: Click and open the menu panel
        instituteModule.clickInstitutePage();
        
        // Step 2: Open the configuration creation form wizard
        instituteModule.clickAddInstitutes();
        
        // Step 3: Populate core text fields
        instituteModule.enterInstituteName("Global International School");
        
        // Step 4: 💡 Fixed matching suggestion text string so Playwright can locate and click it!
        instituteModule.searchAndSelectAddressSuggestion("Silk Board", "Silk Board, Bengaluru, Karnataka");
        
        // Step 5: Input contact details
        instituteModule.enterMobileNumber("9876543210");
        instituteModule.enterEmailAddress("admin@globalschool.com");
        
        // Step 6: Submit form data
        instituteModule.saveDetails();
        
        System.out.println("✅ Success! New institute workflow complete.");
    }
}
