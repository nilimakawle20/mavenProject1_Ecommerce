package amazon_source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrationpage {
	ChromeDriver driver;
	//step1
	@FindBy(id="ap_customer_name")
	WebElement cust_name;                  
	
	@FindBy(id="ap_phone_number")
	WebElement mobile_no;                 
	
	@FindBy(id="ap_password")
	WebElement pass_key;                  
	
	@FindBy(id="continue")
	WebElement verify_mob_num;                
	
	//step2
		public void enter_custname()                    
		{
			cust_name.sendKeys("Neelima Kawle");
		}
		public void enter_mobile_number()                
		{
			mobile_no.sendKeys("8830157983");
		}
		public void enter_password()                    
		{
			pass_key.sendKeys("Passion@123");
		}
 
		public void verify_mobile_number()                 
		{
			verify_mob_num.click();
		}
		
		//step3
		public Registrationpage(ChromeDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

}
