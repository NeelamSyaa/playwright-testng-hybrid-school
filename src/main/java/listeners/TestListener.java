package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import io.qameta.allure.Attachment;
import com.microsoft.playwright.Page;
import driver.DriverManager;
import Utilities.ScreenshotUtils;

public class TestListener implements ITestListener, IAnnotationTransformer {

    // Automatically hooks the RetryAnalyzer onto every @Test method at runtime safely
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🚀 Starting Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
        Page page = DriverManager.getPage();
        if (page != null) {
            byte[] screenshot = ScreenshotUtils.takeScreenshotAsBytes(page);
            saveScreenshotToAllure(screenshot, result.getName() + "_Failure");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test Skipped: " + result.getName());
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] saveScreenshotToAllure(byte[] screenshot, String screenshotName) {
        return screenshot;
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}
