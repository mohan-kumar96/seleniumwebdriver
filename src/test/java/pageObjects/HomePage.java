package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
    Logger logger = LogManager.getLogger(HomePage.class);
    
    /*public LoginPage(WebDriver driver) {
    	super(driver);
    }*/
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement myAccount;

    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;
    
    public void ClickMyAccount() {
    	myAccount.click();
    }
    
    public void ClickLogin() {
    	loginLink.click();
    }

}
