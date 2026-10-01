package pages;

import com.microsoft.playwright.Locator;

import Config.ConfigManager;

public class vehcielPage  extends  BasePage{



	    private final Locator serachvehicle;
	    
	    public vehcielPage() {
	        super(); 
	        
	       
	        this.serachvehicle = page.getByPlaceholder("Search by Vehicle Details"); 
	    }
	     
	
	    public void navigateToLoginPage() {
	        
	        page.navigate(ConfigManager.getBaseUrl());
	    }
	     
	    public void searchForVehicle(String vehicleId) {
	        serachvehicle.fill(vehicleId);
	    }
	}


