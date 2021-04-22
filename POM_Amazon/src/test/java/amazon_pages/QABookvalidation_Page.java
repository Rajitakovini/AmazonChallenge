package amazon_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class QABookvalidation_Page {
	
	   WebDriver driver;
	   public String pricetag, pricetag2 , pricetag3;
	   
	   public QABookvalidation_Page(WebDriver driver) {
		   this.driver= driver;
		   PageFactory.initElements(driver,this);   
	   }
	   
	   @FindBy(id="twotabsearchtextbox") private WebElement search;
	   public WebElement searchBar() {
		   search.sendKeys("qa testing for beginners");
		   search.sendKeys(Keys.ENTER);
		   return search;
	   }
	
	  @FindBy(xpath="(//span[@class='rush-component']/a/div/img)[1]")private WebElement book;
	  public void bookname() {
		  book.click();
	  }
	  
	  @FindBy(id="newBuyBoxPrice") private WebElement price;
	  public void getPrice() {
		 pricetag =price.getText();
		  return;
	  }
	  
	  @FindBy(id="add-to-cart-button")private WebElement cart;
	  public void addToCart() {
		  cart.click();
}
	  
	  @FindBy(xpath="//span[starts-with(@class,'a-color-price ')]") private WebElement price2;
	  public void getPrice2() {
		  pricetag2 = price2.getText();
	  }
		
	  @FindBy(id="hlb-ptc-btn-native") private WebElement checkout;
	  public void chekout() {
		  checkout.click();
	  }
		  
		  
		  
	  
}
