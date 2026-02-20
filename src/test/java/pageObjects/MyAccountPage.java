package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BasePage;

public class MyAccountPage extends BasePage{
	WebDriver driver;
    Logger logger = LogManager.getLogger(MyAccountPage.class);
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//h2[normalize-space()='My Account']")
WebElement myAccountHeading;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement logoutLink;
	
//Get Heading Text
public String getMyAccountHeading() {
	logger.info("Validating HEading...");
    return myAccountHeading.getText();
    
}

// Logout Method
public void logout() {
    //myAccountDropdown.click();
	logger.info("Logging Out...");
    logoutLink.click();
}

}
