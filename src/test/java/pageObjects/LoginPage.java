package pageObjects;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BasePage;



public class LoginPage extends BasePage {
    WebDriver driver;
    Logger logger = LogManager.getLogger(LoginPage.class);
    
    /*public LoginPage(WebDriver driver) {
    	super(driver);
    }*/
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

@FindBy(xpath="//input[@id='input-email']")
WebElement username;

@FindBy(xpath="//input[@id='input-password']")
WebElement password;

@FindBy(xpath = "//input[@value='Login']")
WebElement loginBtn;

public void login(String user, String pass) {
	logger.info("Entering username");
	username.sendKeys(user);
    logger.info("Entering Password");
    password.sendKeys(pass);
    logger.info("Clicking Login button");
    loginBtn.click();
}
}
