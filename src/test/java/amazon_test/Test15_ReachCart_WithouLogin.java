package amazon_test;
//Reach till cart page without login in amazon application
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Product_Details;
import amazon_source.Search_Result;
@Listeners(utility.Listener1.class)
public class Test15_ReachCart_WithouLogin extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void ReachingCart_WithoutLogin() throws InterruptedException
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
	p1.click_add_to_cart();
	//WebElement buynow_btn=driver.findElement(By.id("buy-now-button"));
	//buynow_btn.click();

}
}
