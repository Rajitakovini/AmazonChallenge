package amazon_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page{
	WebDriver driver;
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath ="//span[text()='Hello, Sign in']") private WebElement signIn;
	public void sign() {
		signIn.click();
	}
	@FindBy(id="ap_email") private WebElement Uname;
	public String userName(String Username) {
		Uname.clear();
		Uname.sendKeys(Username);
		return Username;
	}
	
	@FindBy(id="continue")private WebElement cont;
	public void continue1() {
		cont.click();
	}
	
}
