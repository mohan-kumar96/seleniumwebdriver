package listeners;

import java.awt.Desktop;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.*;
import utilities.ExtentManager;
import utilities.ScreenshotUtility;

import testBase.BasePage;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;
    Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        logger.info("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        logger.info("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed: " + result.getMethod().getMethodName());

        WebDriver driver = BasePage.driver;

        String screenshotPath =
                ScreenshotUtility.captureScreenshot(driver,
                        result.getMethod().getMethodName());

        try {
            test.fail("Test Failed",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(screenshotPath)
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();  // Generate report

        try {
            String reportPath = ExtentManager.getReportPath();

            File htmlFile = new File(reportPath);
System.out.println(" Validate if this is aunched");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
