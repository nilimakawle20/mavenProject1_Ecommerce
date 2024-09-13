package amazon_test;
//Ensure that the product detail page displays all necessary information (price, reviews, description).
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazon_source.Homepage;
import amazon_source.Product_Details;
import amazon_source.Search_Result;

@Listeners(utility.Listener1.class)
public class Test7_Verify_ProductDetailsInfo extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void verify_price_review_description() throws InterruptedException
	{
		Homepage h1=new Homepage(driver);
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
		boolean product_price=p1.price_display().isDisplayed();
		boolean product_review=p1.reviews_display().isDisplayed();
		boolean product_description=p1.product_desc_display().isDisplayed();
		
		Assert.assertEquals(product_price, true, "price is missing on product page");
		Assert.assertEquals(product_review, true, "review is missing on product page");
		Assert.assertEquals(product_description, true, "product desc is missing on product page");
	}

}
