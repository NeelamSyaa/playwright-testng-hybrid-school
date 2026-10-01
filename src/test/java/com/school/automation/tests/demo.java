/*
 * package com.school.automation.tests;
 * 
 * import javax.naming.Context;
 * 
 * import com.microsoft.playwright.Browser; import
 * com.microsoft.playwright.BrowserContext; import
 * com.microsoft.playwright.BrowserType; import
 * com.microsoft.playwright.Frame.GetByRoleOptions; import
 * com.microsoft.playwright.Page; import com.microsoft.playwright.Playwright;
 * import com.microsoft.playwright.options.AriaRole;
 * 
 * public class demo {
 * 
 * 
 * public static void main(String[] args) { Playwright p = Playwright.create();
 * Browser Browser = p.chromium().launch( new
 * BrowserType.LaunchOptions().setHeadless(false)); BrowserContext Context =
 * Browser.newContext(); Page page = Context.newPage();
 * page.navigate("https://school-dev.syaa.xyz/");
 * page.locator("[name=\"username\"]").fill("5456765876");
 * page.locator("[name=\"password\"]").fill("5456765876");
 * page.getByRole(AriaRole.BUTTON, new
 * Page.GetByRoleOptions().setName("Login").setExact(true)).click();
 * page.waitForLoadState(); page.getByText("Students").click();
 * 
 * // page.close(); // Context.close(); // Browser.close(); }
 * 
 * }
 */