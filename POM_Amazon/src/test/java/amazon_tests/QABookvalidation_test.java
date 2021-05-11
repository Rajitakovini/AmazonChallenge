package amazon_tests;




import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import amazon_pages.QABookvalidation_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QABookvalidation_test extends BaseClass{
	public static Logger log =   (Logger) LogManager.getLogger(QABookvalidation_test.class);
	
	String expectedPrice = "$47.49";
	
	
	
	@Test
	public void validatingPrice() {
		QABookvalidation_Page qabook = new QABookvalidation_Page(driver);
		qabook.searchBar();
		log.trace("Value entered in search bar");
		qabook.bookname();
		qabook.getPrice();
		SoftAssert asst = new SoftAssert();
		Assert.assertEquals(expectedPrice, qabook.pricetag);
		log.info("Both the prices validated");
		qabook.addToCart();
		log.info("item added to the cart");
		qabook.getPrice2();
		Assert.assertEquals(expectedPrice,qabook.pricetag2);
		qabook.chekout();
		log.info("clicked on checkout");
		
		asst.assertAll();
	}

}