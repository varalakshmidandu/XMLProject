package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {

	WebDriver driver;
	
	//Test Data
		String userName="demo@techfios.com";
		String password = "abc123";
		String dashboardHeaderText; 
		String fullName;
		String company;
		String email;
		String phone;
		String address;
		String city;
		String state;
		String zip;
		String country;
	//@Test
		@Parameters({"userName", "password", "dashboardHeaderText", "fullName", "companyName", "email", "phone", "address", "city", "state", "zip", "country"})
		public void userShouldBeAbleToAddCustomer(String userName, String password, String dashboardHeaderText, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) throws InterruptedException {
			
			driver = BrowserFactory.init();
			
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.insertUserName(userName);
			loginPage.insertPassword(password);
			loginPage.clickSignInButton();
			
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.validateDashboardPage(dashboardHeaderText);
			dashboardPage.clickCustomersButton();
			dashboardPage.clickAddCustomersButton();
			
			AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
			addContactPage.insertFullName(fullName);
			addContactPage.selectCompany(company);
			addContactPage.insertEmail(email);
			addContactPage.insertPhoneNum(phone);
			addContactPage.insertAddress(address);
			addContactPage.insertCity(city);
			addContactPage.insertState(state);
			addContactPage.insertZip(zip);
			addContactPage.selectCountry(country);
			addContactPage.clickSaveButton();
			
			dashboardPage.clickListCustomersButton();;
			addContactPage.validateInsertedNameAndDelete();

		}
		
		@Test
		@Parameters({"userName", "password", "dashboardHeaderText", "fullName", "companyName", "email", "phone", "address", "city", "state", "zip", "country"})
		public void userShouldBeAbleToAddCustomerFromListCustomer(String userName, String password, String dashboardValidationText, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) throws InterruptedException {
			
			driver = BrowserFactory.init();
			
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.insertUserName(userName);
			loginPage.insertPassword(password);
			loginPage.clickSignInButton();
			
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.validateDashboardPage(dashboardValidationText);
			dashboardPage.clickCustomersButton();
			dashboardPage.clickListCustomersButton();
			
			AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
			addContactPage.clickAddCustomerOnListCustomer();
			addContactPage.insertFullName(fullName);
			addContactPage.selectCompany(company);
			addContactPage.insertEmail(email);
			addContactPage.insertPhoneNum(phone);
			addContactPage.insertAddress(address);
			addContactPage.insertCity(city);
			addContactPage.insertState(state);
			addContactPage.insertZip(zip);
			addContactPage.selectCountry(country);
			addContactPage.clickSaveButton();
			
			dashboardPage.clickListCustomersButton();
			addContactPage.insertSearchBoxOnListCustomer();
			addContactPage.validateInsertedNameOnSearchBarAndProfile();
			

		}
}
