package amazon_source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.DDT;

public class Login_Amazon extends DDT{
	ChromeDriver driver;
	//step1
	@FindBy(name="email")                         
	WebElement username;
	
	@FindBy(id="continue")                       
	WebElement continue_button;
	
	@FindBy(id="ap_password")                    
	WebElement password;
	
	@FindBy(id="signInSubmit")                       
	WebElement signin_button;
	
	//step2
		public void enter_username()                
		{
			username.sendKeys(un);
		}
		public void cont()                        
		{
			continue_button.click(); 
		}
		public void enter_password()                  
		{
			password.sendKeys(pwd);
		}

		public void signin()                           
		{
			signin_button.click();
		}
		
		public void invalid_username()                  
		{
			username.sendKeys("nilimakawle@gmail.com");
		}
		
		public void invalid_password()                    
		{
			password.sendKeys("Awesome@20");
		}
		//step3
		public Login_Amazon(ChromeDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
}
