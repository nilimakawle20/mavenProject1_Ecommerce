package amazon_test;
//Verify that searching with filters (e.g., category, price range) yields accurate results.
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazon_source.Homepage;
import amazon_source.Search_Result;

@Listeners(utility.Listener1.class)
public class Test6_SearchWithFilters extends LaunchQuit{
        @Test(retryAnalyzer=utility.RetryLogic.class)
        public void searching_with_filters() throws InterruptedException
        {
        	Homepage h1=new Homepage(driver);
    		h1.categorySelect("Books");
    		h1.search("Books");
    		
    		Assert.assertEquals(driver.getTitle(), "Amazon.in : Books");
    		
        }
}
