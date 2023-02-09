package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContactPage extends BasePage {

WebDriver driver;
	
	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 String insertedName;
	
	 @FindBy(how = How.XPATH, using ="//*[@id=\"account\"]") WebElement fullNameElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"cid\"]") WebElement companyElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"email\"]") WebElement emailElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"phone\"]") WebElement phoneElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"address\"]") WebElement addressElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"city\"]") WebElement cityElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"state\"]") WebElement stateElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"zip\"]") WebElement zipElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"country\"]") WebElement countryElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"submit\"]") WebElement saveElement;
		@FindBy(how = How.XPATH, using ="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement addCustomerOnListCustomer;
		@FindBy(how = How.XPATH, using ="//*[@id=\"foo_filter\"]") WebElement searchOnListCustomer;
		
	
		public void insertFullName(String fullName) {
			insertedName = fullName + generateRandomNum(999);
			fullNameElement.sendKeys(insertedName);
		}
		
		public void selectCompany(String company) {
			selectFromDropdown(companyElement, company);
		}
		
		public void insertEmail(String email) {
			emailElement.sendKeys(generateRandomNum(9999) + email);
		}
		
		public void insertPhoneNum(String phoneNum) {
			phoneElement.sendKeys(phoneNum + generateRandomNum(9999));
		}
		public void insertAddress(String address) {
			addressElement.sendKeys(address);
		}
		public void insertCity(String city) {
			cityElement.sendKeys(city);
		}
		public void insertState(String state) {
			stateElement.sendKeys(state);
		}
		public void insertZip(String zip) {
			zipElement.sendKeys(zip);
		}
		public void selectCountry(String country) {
			selectFromDropdown(countryElement, country);
		}
		public void clickSaveButton() {
			saveElement.click();
		}
		
		//tbody/tr[1]/td[3]/a
		//tbody/tr[2]/td[3]/a
		//tbody/tr[3]/td[3]/a
		//tbody/tr[i]/td[3]/a/following-sibling::td[4]/a[2]
		//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
		//tbody/tr[1]/td[7]/a[2]
		
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]/a";
		String after_xpath_delete_button = "]/td[3]/following-sibling::td[4]/a[2]";
		String after_xpath_profile_button = "]/td[3]/following-sibling::td[4]/a[1]";
		
		public void validateInsertedNameAndDelete() {
			for (int i = 1; i <= 10; i++) {
				String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				//System.out.println(actualName);
				//Assert.assertEquals(actualName, insertedName, "name not found!!!");
				if (actualName.contains(insertedName)) {
					System.out.println("Inserted name exist.");
					driver.findElement(By.xpath(before_xpath + i + after_xpath_delete_button)).click();
				}
				
				break;
			}
			
		}
		
		public void clickAddCustomerOnListCustomer() {
			addCustomerOnListCustomer.click();
		}
		
		public void insertSearchBoxOnListCustomer() {
			searchOnListCustomer.sendKeys(insertedName);
		}
		
		public void validateInsertedNameOnSearchBarAndProfile() {
			for(int i = 1; i <= 5; i++) {
				String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				if(actualName.equals(insertedName)) {
					System.out.println("Inserted name exist!!");
					driver.findElement(By.xpath(before_xpath + i + after_xpath_profile_button)).click();
				}
				break;
			}
		}
}
