package amazon_test;
import org.testng.Assert;
//Test searching for products using its name like shoe
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Search_Result;

@Listeners(utility.Listener1.class)
public class Test5_SearchProduct extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void searching_the_product()
	{
		Homepage h1=new Homepage(driver);
		h1.search("Shoes");
		
		Search_Result s1=new Search_Result(driver);
		boolean sortby=s1.sortby().isDisplayed();
		
		Assert.assertEquals(sortby, true, "Sort by dropdown is displaying");
	}
}
