package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	static String repName;

    private static ExtentReports extent;
    private static String reportPath;

    public static ExtentReports getInstance() {

        if (extent == null) {
        	
        	String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
        	repName = "AutomationReport" + timeStamp + ".html";

            String reportPath = System.getProperty("user.dir")
                    + "/reports/" + repName;

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Automation Test Report");	
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Username", System.getProperty("user.name"));
        }

        return extent;
    }
    public static String getReportPath() {
        return reportPath;
    }
}
