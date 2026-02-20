package testBase;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {

    public static WebDriver driver;
    public Logger logger;
    
    @BeforeClass
    @Parameters({"os","browser"})
    

    public void setup(String os, String br) throws MalformedURLException {
    	
    	logger = LogManager.getLogger(this.getClass());
    	logger.info("Launching browser...");
    	
    	/**/
    	if(ConfigReader.getProperty("execution_envt").contentEquals("remote")) {
    		ChromeOptions options = new ChromeOptions();
        	options.addArguments("--start-maximized");

        	driver = new RemoteWebDriver(
        	        new URL("http://localhost:4444"),
        	        options
        	);
    	}
    	
    	if(ConfigReader.getProperty("execution_envt").contentEquals("local")) {
    		switch(br.toLowerCase())
        	{
        	case "chrome" : driver = new ChromeDriver(); break;
        	case "edge" : driver = new EdgeDriver(); break;
        	default : System.out.println("Invalid Broswer Name..."); return;
        	
        	}
    		
    	}
        
        
    	//driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("url"));
       
        //logger.info("Application launched successfully.");
    }

    @AfterClass
    public void tearDown() {
    	logger.info("Closing browser...");
        driver.quit();
    }
}
