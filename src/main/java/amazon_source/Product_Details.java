package amazon_source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Details {
ChromeDriver driver;                          
  @FindBy(id="add-to-cart-button")
  WebElement add_to_cart_btn;
 
  @FindBy(xpath="//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']") 
  WebElement price;
  
  @FindBy(xpath="(//span[@class='a-size-base a-color-base'])[1]")        
  WebElement reviews;
  
  @FindBy(id="productDescription")          
  WebElement product_desc;
  
  @FindBy(name = "proceedToRetailCheckout")   
  WebElement proceed_to_buy;
  
  @FindBy(id="buy-now-button")
  WebElement buy_now_btn;
  
  public WebElement price_display()      
  {
	 return price;
  }
  
  public WebElement reviews_display()     
  {
	 return reviews;
  }
  
  public WebElement product_desc_display()    
  {
	 return product_desc;
  }
  
  public void click_add_to_cart()       
  {
	  add_to_cart_btn.click();
  }
  
  public void proceed_to_buy()            
  {
	  proceed_to_buy.click();
  }
 

  public void click_buy_now()
  {
	  buy_now_btn.click();
  }
  public Product_Details(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
