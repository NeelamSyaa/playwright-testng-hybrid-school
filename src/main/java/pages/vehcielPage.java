package pages;

import com.microsoft.playwright.Locator;

import Config.ConfigManager;

public class vehcielPage  extends  BasePage{



	    private final Locator serachvehicle;
	    
	    public vehcielPage() {
	        super(); // Links this page object to the active browser window
	        
	        // Maps the locator using your exact placeholder definition
	        this.serachvehicle = page.getByPlaceholder("Search by Vehicle Details"); 
	    }
	     
	    // 💡 This method gives your test the ability to jump directly to the dashboard
	    public void navigateToDashboardPage() {
	        navigateTo(ConfigManager.getBaseUrl());
	    }
	     
	    public void searchForVehicle(String vehicleId) {
	        serachvehicle.fill(vehicleId);
	    }
	}


