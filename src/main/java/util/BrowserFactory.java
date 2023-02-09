package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	 static WebDriver driver;
	   static String browser = "chrome";
	   static String url = "https://techfios.com/billing/?ng=admin/";

	@BeforeMethod
	public static WebDriver init() {
			
			if (browser.equalsIgnoreCase("chrome")) {

				//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")){

		       //System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
	        WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			
			driver.manage().deleteAllCookies();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	   
		}
		public static void tearDown() {
			driver.close();
			driver.quit();
		}
	
}
