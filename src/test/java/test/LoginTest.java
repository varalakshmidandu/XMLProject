package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	//Test Data
	String userName;
	String password;
	String dashboardValidationText; 
			
	

	@Test
	@Parameters({"userName", "password", "dashboardHeaderText"})
	public void validUserShouldBeAbleToLogin(String userName, String password, String dashboardHeaderText) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderText);
		
		BrowserFactory.tearDown();
		
	}
	
}
