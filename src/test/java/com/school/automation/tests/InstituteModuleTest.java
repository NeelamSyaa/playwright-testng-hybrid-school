package com.school.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver.DriverManager;
import pages.Institutepage;

public class InstituteModuleTest extends BaseTest {

	    private Institutepage instituteModule;

	    @BeforeClass
	    public void setupClassSession() {
	        // 1. Instantly navigate to your application dashboard domain via shared token properties
	        DriverManager.getPage().navigate(Config.FrameworkConfig.get("url"));
	        DriverManager.getPage().waitForURL("**/myFleet");
	        
	        this.instituteModule = new Institutepage();
	    }

	    @Test
	    public void verifyCreateNewInstituteWorkflow() {
	        // Step 1: Open the Institute sub-module layout component view
	        instituteModule.clickInstitutePage();
	        
	        // Step 2: Open the registration dialog form wizard window
	        instituteModule.clickAddInstitutes();
	        
	        // Step 3: Populate core text components
	        instituteModule.enterInstituteName("Global International School");
	        
	        // Step 4: Automate the Address field Auto-Suggestion selection
	        // Types a shorthand location and matches against the exact layout suggestion row
	        instituteModule.searchAndSelectAddressSuggestion("Bengaluru", "Bengaluru, Karnataka, India");
	        
	        // Step 5: Input context metrics
	        instituteModule.enterMobileNumber("9876543210");
	        instituteModule.enterEmailAddress("admin@globalschool.com");
	        
	        // Step 6: Submit form records
	        instituteModule.saveDetails();
	        
	        System.out.println("🚀 Success! New institute configuration created cleanly without navigating the login screen.");
	    }
	}


