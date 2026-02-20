package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver, String testName) {

        // Create timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        // Screenshot folder path
        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";

        // Create folder if not exists
        new File(screenshotDir).mkdirs();

        // File path
        String filePath = screenshotDir + testName + "_" + timestamp + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
