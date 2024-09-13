package amazon_source;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	ChromeDriver driver;
	//step1
	@FindBy(id="nav-link-accountList")
	WebElement accountandlist;                            
	
	@FindBy(xpath="(//span[.='Sign in'])[1]")
	WebElement signinbutton;                               
	
	@FindBy(xpath= "//select[@id='searchDropdownBox']")    
	WebElement category_dropdown;
	
	@FindBy(id="twotabsearchtextbox")                     
	WebElement search_field;
	
	@FindBy(xpath="(//a[.='Start here.'])[1]")           
	WebElement start_here_link;
	
	@FindBy(xpath="//div[@class='two-pane-results-container']/div/div")
	List<WebElement> auto;
	
	@FindBy(id="nav-orders")
	WebElement returns_and_orders;
	
	@FindBy(id="nav-cart")                  
	WebElement shopping_cart;
	
	//step2
	public void accountlist(ChromeDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountandlist).perform();                
	}

	public void signin() throws InterruptedException
	{
		signinbutton.click();
	}
	
	public void search(String productname)                                 
	{
		search_field.sendKeys(productname+Keys.ENTER);
	}
	
	public void register_link()
	{
		start_here_link.click();                                        
	}
	
    public void categorySelect(String categoryName)    
    {
		Select s=new Select(category_dropdown);
		s.selectByVisibleText(categoryName);
	}
	
	
	public void click_autosuggestion()
	{
		search_field.sendKeys("shoe");
		int count=auto.size();
		auto.get(count-7).click();
	}
	
	public void click_returns_orders()
	{
		returns_and_orders.click();
	}
	
	public void click_shopping_cart()            
	{
		shopping_cart.click();
	}
	
	public WebElement acc_list()
	{
		return accountandlist;
	}
	
	//step3
	public Homepage(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
