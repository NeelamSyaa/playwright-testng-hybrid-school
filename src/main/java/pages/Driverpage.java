package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

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
        
        // 💡 FIXED: Uses getByRole with setExact(true) to avoid matching "Codrivers"
        this.driversTabBtn = page.getByRole(AriaRole.TAB, 
            new Page.GetByRoleOptions().setName("Drivers").setExact(true));
        
        this.addDriverBtn = page.locator("button:has-text('Add Drivers'), button:has-text('Add Driver')").first();
        this.driverNameField = page.getByPlaceholder("Enter Driver Name");
        this.licenseNumberField = page.getByPlaceholder("Enter Driving License Number");
        this.dateOfBirthPicker = page.locator(".MuiPickersInputBase-sectionsContainer, input[placeholder*='DD']").first();
        this.phoneNumberField = page.getByPlaceholder("Enter Phone Number");
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

    public boolean isDriverTextPresentInGrid(String driverText) {
        return page.locator("td:has-text('" + driverText + "'), .MuiDataGrid-cell:has-text('" + driverText + "')")
                   .first()
                   .isVisible();
    }
}
