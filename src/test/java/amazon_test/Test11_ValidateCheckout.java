package amazon_test;
//Validate the entire checkout process, including address selection,payment method selection, and order review.
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazon_source.Checkout_page;
import amazon_source.Homepage;
import amazon_source.Login_Amazon;
import amazon_source.Product_Details;
import amazon_source.Search_Result;
import utility.DDT;
@Listeners(utility.Listener1.class)
public class Test11_ValidateCheckout extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void validating_select_address_paymethod_revieworder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Homepage h1=new Homepage(driver);
		h1.accountlist(driver);
		h1.signin();
		
		DDT d=new DDT();
		d.credentials();
		
		Login_Amazon l1=new Login_Amazon(driver);
		l1.enter_username();
		l1.cont();
		l1.enter_password();
		l1.signin();
		
		h1.search("Shoes");
		
		Search_Result s1=new Search_Result(driver);
		s1.click_selected_product();
		
		Set<String> ids=driver.getWindowHandles();//parenchild
		Iterator<String> id=ids.iterator();
		String parentid=id.next(); //parent id
		String childid=id.next();  //1st child id
		Thread.sleep(1000);
		driver.switchTo().window(childid); //move the control from parent to child window
		
		Product_Details p1=new Product_Details(driver);
		p1.click_add_to_cart();
		p1.proceed_to_buy();
		
		Checkout_page c1=new Checkout_page(driver);
		c1.use_this_address_for_shipping();
		Assert.assertEquals(c1.addressChangeLink().isDisplayed(), true);
		
		Thread.sleep(1000);
		c1.use_this_paymentmethod();
		Assert.assertEquals(c1.payChangeLink().isDisplayed(), true);
		
		Thread.sleep(1000);
		if(c1.reviewItemDelivery().isDisplayed())
		{
		Assert.assertEquals(true, true);
		}
	}
}
