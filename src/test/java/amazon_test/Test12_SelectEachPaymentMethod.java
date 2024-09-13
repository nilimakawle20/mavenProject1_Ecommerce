package amazon_test;
//Check if user is able to select each payment method
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
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
public class Test12_SelectEachPaymentMethod extends LaunchQuit {
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void selecting_each_payemntmethod() throws InterruptedException, EncryptedDocumentException, IOException
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
		p1.click_buy_now();
		
		Checkout_page c1=new Checkout_page(driver);
		c1.creditcard_radiobutton().click();
		boolean creditcard=c1.creditcard_radiobutton().isSelected();
		Assert.assertEquals(creditcard, true, "CC radio button not enabled");
		
		c1.netbanking_radiobutton().click();
		boolean netbanking=c1.netbanking_radiobutton().isSelected();
		Assert.assertEquals(netbanking, true, "Netbanking radio button not enabled");
		
		c1.otherUPIApps_radiobutton().click();
		boolean upi=c1.otherUPIApps_radiobutton().isSelected();
		Assert.assertEquals(upi, true, "UPI apps radio button not enabled");
		
	   /* c1.emi_radiobutton().click();
		boolean emi=c1.emi_radiobutton().isSelected();
		Assert.assertEquals(emi, true, "EMI radio button not enabled"); */
		
		
		c1.cashondelivery_radiobutton().click();
		boolean cod=c1.cashondelivery_radiobutton().isSelected();
		Assert.assertEquals(cod, true, "cash on delivery not enabled");
	}
}
		