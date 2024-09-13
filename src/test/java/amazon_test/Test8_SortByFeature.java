package amazon_test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//Check if products can be sorted by relevance, price, rating, etc
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Search_Result;
@Listeners(utility.Listener1.class)
public class Test8_SortByFeature extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void sort_product_by() throws InterruptedException
	{
		Homepage h1=new Homepage(driver);
		h1.search("shoes");
		
		Search_Result s1=new Search_Result(driver);
		Thread.sleep(2000);
		s1.click_sortby_dropdwn();
		
		String current_url=driver.getCurrentUrl();
		System.out.println(current_url);
		Assert.assertEquals(current_url.contains("price-asc-rank"),true,"sorry");
	}

}
