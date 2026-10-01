package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Institutepage extends BasePage {

    private final Locator institutePageBtn;
    private final Locator addInstitutesBtn;
    private final Locator enterInstituteNameField;
    private final Locator addressSearchField;
    private final Locator dropdownOptions; // 💡 Dynamic item choices selector
    private final Locator mobileNumberField;
    private final Locator emailIdField;
    private final Locator saveBtn;

    public Institutepage() {
        super();
        
        // Target structural elements cleanly using standard attributes and text values
        this.institutePageBtn = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Institutes"));
        this.addInstitutesBtn = page.locator("button:has-text('Add Institutes'), button:has(span:has-text('Add Institutes'))");
        this.enterInstituteNameField = page.locator("input[placeholder*='Enter Institute Name']");
        
        // This is the input box where you physically type your location search
        this.addressSearchField = page.locator("input[placeholder*='Institute Address'], input[placeholder*='Search']");
        
        // 💡 Targets the dynamic pop-up drop-down choices that display under the field box
        this.dropdownOptions = page.locator("[role='option'], .pac-item, .suggestion-item, li");
        
        this.mobileNumberField = page.locator("input[placeholder*='mobile number']");
        this.emailIdField = page.locator("input[placeholder*='email address']");
        this.saveBtn = page.locator("button:has-text('Save Details'), button[type='submit']");
    }                        
	
    public void clickInstitutePage() {
        institutePageBtn.click();
    }

    public void clickAddInstitutes() {
        addInstitutesBtn.click();
    }

    public void enterInstituteName(String schoolName) {
        enterInstituteNameField.fill(schoolName);
    }
	
    /**
     * Types an address location keyword, waits for dynamic pop-ups, and clicks the target option.
     */
    public void searchAndSelectAddressSuggestion(String partialAddress, String exactAddressToSelect) {
        addressSearchField.click();
        addressSearchField.fill(partialAddress);
        
        // Explicitly wait for options to map to the browser screen view
        dropdownOptions.first().waitFor();
        
        // Filter the active selection down to your exact match and perform click operations
        dropdownOptions.filter(new Locator.FilterOptions().setHasText(exactAddressToSelect)).first().click();
        System.out.println("🎯 Location Auto-Suggestion Selected: " + exactAddressToSelect);
    }
	
    public void enterMobileNumber(String mobileNumber) {
        mobileNumberField.fill(mobileNumber); // 💡 Fixed the copy-paste variable error
    }

    public void enterEmailAddress(String validEmail) {
        emailIdField.fill(validEmail);
    }
	
    public void saveDetails() {
        saveBtn.click();
    }
}
