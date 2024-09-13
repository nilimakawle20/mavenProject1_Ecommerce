package amazon_source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orders_page {
	ChromeDriver driver;
	
	@FindBy(linkText="Write a product review")
	WebElement add_review_btn;
	
	public void click_product_review_button()
	{
		add_review_btn.click();
	}
	
	public Orders_page(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
