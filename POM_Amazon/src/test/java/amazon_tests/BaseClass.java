package amazon_tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	WebDriver driver;



	@Parameters({ "browser" ,"url" })
	@BeforeTest
	public void setUp(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"//Users//rajitachenna//eclipse-workspace//POM_Amazon//Drivers//chromedriver");
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", " ");
			driver = new EdgeDriver();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", " ");
			driver = new FirefoxDriver();
		}else {
			Reporter.log("no browser specified");
		}
		
		
		driver.get(url);

		
		
		
		
		
		
		
		
		/*
		 * try { fis = new FileInputStream(
		 * "/Users/rajitachenna/eclipse-workspace/POM_Amazon/testdata/config.properties"
		 * ); prop = new Properties(); prop.load(fis); fis.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } }
		 * 
		 * 
		 * public String drive() { String browserName = prop.getProperty("Browser");
		 * 
		 * 
		 * if(browserName.equals("Chrome")) { driver= new ChromeDriver();
		 * System.setProperty("webdriver.chrome.driver",
		 * System.getProperty("user.dir")+"//Drivers//chromedriver");
		 * 
		 * 
		 * 
		 * return browserName; }else { throw new
		 * RuntimeException("driverpath not specified"); }
		 */
	}

	@AfterTest(enabled = false)
	public void tearDown() {
		driver.quit();
		Reporter.log("=====browser session ended=====", true);
	}
}