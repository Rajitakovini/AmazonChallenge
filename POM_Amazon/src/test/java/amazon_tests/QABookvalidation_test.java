package amazon_tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import amazon_pages.QABookvalidation_Page;



public class QABookvalidation_test extends BaseClass {
	String expectedPrice = "$47.49";
	
	@Test
	public void validatingPrice() {
		QABookvalidation_Page qabook = new QABookvalidation_Page(driver);
		qabook.searchBar();
		qabook.bookname();
		qabook.getPrice();
		SoftAssert asst = new SoftAssert();
		AssertJUnit.assertEquals(expectedPrice, qabook.pricetag);
		qabook.addToCart();
		qabook.getPrice2();
		AssertJUnit.assertEquals(expectedPrice,qabook.pricetag2);
		qabook.chekout();
		
		asst.assertAll();
	}

}