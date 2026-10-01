package Utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitUtils {

	
	public static void waitForElementVisible(Page page, String selector, int timeoutMs) {
        page.waitForSelector(selector, new com.microsoft.playwright.Page.WaitForSelectorOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(timeoutMs));
    }

    public static void waitForElementHidden(Page page, String selector, int timeoutMs) {
        page.waitForSelector(selector, new com.microsoft.playwright.Page.WaitForSelectorOptions()
            .setState(WaitForSelectorState.HIDDEN)
            .setTimeout(timeoutMs));
    }

    public static void waitForLocatorState(Locator locator, WaitForSelectorState state) {
        locator.waitFor(new com.microsoft.playwright.Locator.WaitForOptions().setState(state));
    }
	}


