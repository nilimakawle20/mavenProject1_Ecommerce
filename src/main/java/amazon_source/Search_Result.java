package amazon_source;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search_Result {
	ChromeDriver driver;	
	
	@FindBy(id="s-result-sort-select")         
	WebElement sort_by_drpdwn;
	
	@FindBy(xpath = "//span[.='Sort by:']")   
	WebElement sort_by;
	
	@FindBy(xpath="(//div[@class='a-section aok-relative s-image-tall-aspect'])[3]") 
	WebElement selected_product;

	public void click_selected_product()          
	{
		selected_product.click();
	}
	
	public void click_sortby_dropdwn()              
	{
		Select s=new Select(sort_by_drpdwn);
		s.selectByVisibleText("Price: Low to High");
		//s.selectByVisibleText("Price: High to Low");
		//s.selectByVisibleText("Avg. Customer Review");
	}
	
	public WebElement sortby()                      
	{
		return sort_by;
	}
	
	public Search_Result(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
