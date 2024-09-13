package amazon_test;
//Test updating item quantities and removing items from the cart.
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazon_source.Homepage;
import amazon_source.Login_Amazon;
import amazon_source.Product_Details;
import amazon_source.Search_Result;
import amazon_source.Shopping_Cart;
import utility.DDT;
@Listeners(utility.Listener1.class)
public class Test10_AddRemoveProductFromCart extends LaunchQuit{
	
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void updating_productquantityincart() throws InterruptedException, EncryptedDocumentException, IOException
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
		
		h1.click_shopping_cart();
		
		Shopping_Cart sh=new Shopping_Cart(driver);
		sh.remove_product_from_cart();
	}

}
