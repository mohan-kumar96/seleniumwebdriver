package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import testBase.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.ExcelUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BasePage {

	@DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        return ExcelUtility.getTestData("Login");
    }
    
    Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(dataProvider = "loginData")
    
    public void verifyLogin(String username, String password) {
    	
    	logger.info("Starting Login Test");
    	
    	HomePage homePage  = new HomePage(driver);
    	homePage.ClickMyAccount();
    	homePage.ClickLogin();
    	
    	LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

     // My Account Page
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Validate Heading
        String actualHeading = myAccountPage.getMyAccountHeading();
        Assert.assertEquals(actualHeading, "My Account");

        // Logout
        myAccountPage.logout();
        
        
        
    	logger.info("Login Test Completed");
    }
}
