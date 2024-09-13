package amazon_source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shopping_Cart {
	ChromeDriver driver;
	
	@FindBy(xpath="(//input[@class='a-color-link'])[1]")      
	WebElement delete_link;
	
	public void remove_product_from_cart()        
	{
		delete_link.click();
	}
	
	public Shopping_Cart(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
