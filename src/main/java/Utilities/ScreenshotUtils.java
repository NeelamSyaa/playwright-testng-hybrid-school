package Utilities;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class ScreenshotUtils {


	 public static String takeScreenshot(Page page, String fileName) {
	        String path = "target/screenshots/" + fileName + "_" + System.currentTimeMillis() + ".png";
	        page.screenshot(new com.microsoft.playwright.Page.ScreenshotOptions()
	            .setPath(Paths.get(path))
	            .setFullPage(true));
	        return path;
	    }

	    public static byte[] takeScreenshotAsBytes(Page page) {
	        return page.screenshot(new com.microsoft.playwright.Page.ScreenshotOptions().setFullPage(true));
	    }
}
