package com.school.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver.DriverManager;
import pages.Driverpage;

public class DriverModuleTest extends BaseTest {

	    private Driverpage driverModule;

	    @BeforeClass
	    public void setupClassSession() {
	        // 1. Immediately navigate to your active fleet environment path via shared token session configs
	        DriverManager.getPage().navigate(Config.FrameworkConfig.get("url"));
	        DriverManager.getPage().waitForURL("**/myFleet");
	        
	        this.driverModule = new Driverpage();
	    }

	    @Test
	    public void verifyAddNewDriverWorkflow() {
	        // Step 1: Click the drivers horizontal navigation tab component
	        driverModule.clickDriversTab();
	        
	        // Step 2: Open the driver creation modal overlay form
	        driverModule.clickAddDriverButton();
	        
	        // Step 3: Populate core textual info metrics
	        String testDriverName = "John Doe Test";
	        driverModule.enterDriverDetails(
	            testDriverName, 
	            "DL-1234567890123", 
	            "01011990", // Passes date text directly to matching picker element
	            "9876543210"
	        );
	        
	        // Step 4: Click fetch and complete save actions
	        driverModule.clickFetchDetails();
	        driverModule.clickSaveDriver();
	        
	        // Step 5: 🎯 ASSERTION CHECK: Check if the text matches the live HTML cell DOM class element text
	        boolean isDriverAdded = driverModule.isDriverTextPresentInGrid(testDriverName);
	        Assert.assertTrue(isDriverAdded, "Test Failed: The new driver name string was not found inside the HTML grid cell rows!");
	        
	        System.out.println("Success! New driver created and validated inside the HTML DOM grid layout.");
	    }
	}


