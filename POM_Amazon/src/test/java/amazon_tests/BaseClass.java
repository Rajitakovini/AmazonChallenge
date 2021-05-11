package amazon_tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;

	/*
	 * @Parameters({ "browser" ,"url" })
	 * 
	 * @BeforeTest public void setUp(String browser, String url) {
	 * 
	 * if (browser.equalsIgnoreCase("chrome")) {
	 * WebDriverManager.chromedriver().setup(); 
	 * driver = new ChromeDriver();
	 * 
	 * } else if (browser.equalsIgnoreCase("edge")) {
	 * WebDriverManager.edgedriver().setup(); 
	 * driver = new EdgeDriver();
	 * 
	 * } else if(browser.equalsIgnoreCase("firefox")) {
	 * WebDriverManager.firefoxdriver().setup();
	 *  driver = new FirefoxDriver();
	 * 
	 * }else { Reporter.log("no browser specified"); }
	 */

	// driver.get(url);

	@BeforeTest
	public WebDriver invokingDriver() {

		try {
			fis = new FileInputStream(
					"/Users/rajitachenna/git/AmazonChallenge/POM_Amazon/testdata/config.properties");
			prop = new Properties();
			prop.load(fis);
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		String browserName = prop.getProperty("Browser");

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else {	
			
			System.out.println("browser name is not specified");
		}
		return driver;
	}
	
	@BeforeTest
	public WebDriver navigateToUrl() {
		String urlName = prop.getProperty("url");
		if(urlName!=null) {
			driver.get(urlName);
		} else {
			System.out.println("url is not specified");
		}
		return driver;
	}
	

	@AfterTest(enabled = false)
	public void tearDown() {
		driver.quit();
		Reporter.log("=====browser session ended=====", true);
	}
}