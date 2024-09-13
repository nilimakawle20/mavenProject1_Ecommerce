package amazon_test;
//Go to orders page and click on your last ordered product and give 5star ratings
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Login_Amazon;
import amazon_source.Orders_page;
import utility.DDT;
@Listeners(utility.Listener1.class)
public class Test14_WriteReview extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void write_review_for_lastorderedproduct() throws InterruptedException, EncryptedDocumentException, IOException
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
		
		h1.click_returns_orders();
		
		Orders_page o1=new Orders_page(driver);
		o1.click_product_review_button();	
	}	
}
