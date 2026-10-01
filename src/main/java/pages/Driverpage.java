package pages;

import com.microsoft.playwright.Locator;

public class Driverpage extends BasePage {
	    
    private final Locator driversTabBtn;
    private final Locator addDriverBtn;
    private final Locator driverNameField;
    private final Locator licenseNumberField;
    private final Locator dateOfBirthPicker;
    private final Locator phoneNumberField;
    private final Locator fetchDetailsBtn;
    private final Locator saveDriverBtn;

    public Driverpage() {
        super(); // Connects to the active browser context
        
        // Map elements cleanly using standard attributes and text values
        this.driversTabBtn = page.locator("button:has-text('Drivers')");
        
        // Simplified the fragile primary primary class selector to target the dynamic layout button text
        this.addDriverBtn = page.locator("button:has-text('Add Drivers'), button:has-text('Add Driver')").first();
        
        this.driverNameField = page.getByPlaceholder("Enter Driver Name");
        this.licenseNumberField = page.getByPlaceholder("Enter Driving License Number");
        
        // Material UI Date Picker input wrapper
        this.dateOfBirthPicker = page.locator(".MuiPickersInputBase-sectionsContainer, input[placeholder*='DD']").first();
        
        this.phoneNumberField = page.getByPlaceholder("Enter Phone Number");
        
        // 💡 Fixed: Correctly assigned your action buttons using structural text lookups
        this.fetchDetailsBtn = page.locator("button:has-text('Fetch Details')");      
        this.saveDriverBtn = page.locator("button:has-text('Add Driver'), button[type='submit']");      
    }

    public void clickDriversTab() {
        driversTabBtn.click();
    }

    public void clickAddDriverButton() {
        addDriverBtn.click();
    }

    public void enterDriverDetails(String name, String license, String dob, String phone) {
        driverNameField.fill(name);
        licenseNumberField.fill(license);
        
        // Select and type or send keys to the Material-UI calendar element
        dateOfBirthPicker.click();
        dateOfBirthPicker.fill(dob);
        
        phoneNumberField.fill(phone);
    }

    public void clickFetchDetails() {
        fetchDetailsBtn.click();
    }

    public void clickSaveDriver() {
        saveDriverBtn.click();
    }

    /**
     * 💡 Checks if a specific driver row text exists dynamically inside the HTML grid list layout
     */
    public boolean isDriverTextPresentInGrid(String driverText) {
        // Target common data grid cell selectors containing the explicit name string
        return page.locator("td:has-text('" + driverText + "'), .MuiDataGrid-cell:has-text('" + driverText + "')")
                   .first()
                   .isVisible();
    }
}
