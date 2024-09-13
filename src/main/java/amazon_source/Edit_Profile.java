package amazon_source;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Profile {
	ChromeDriver driver;
	@FindBy(id="nav-link-accountList-nav-line-1")        
	WebElement user_account_lists;
	
	@FindBy(xpath="//button[.='Manage Profiles']")           
	WebElement acc_holder;
	
	@FindBy(xpath="//a[@class='sc-iGgWBj sc-fHjqPf fErbOa bdPZUm']")     
	WebElement view_btn;
	
	@FindBy(xpath="//span[@class='editProfile']")           
	WebElement edit_profile;
	 
	@FindBy(id="editProfileNameInputId")                     
	WebElement edit_name;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement cont_btn;
	
	public void accountlist_hover(ChromeDriver driver)       
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(user_account_lists).perform();
	}
	
	public void clickon_accountholder()                    
	{
		acc_holder.click();
	}
	

	public void click_view_button()                
	{
		view_btn.click();
	}
	
	public void click_edit_profile()                 
	{
		edit_profile.click();
	}
	
	public void backspace_profile_name()               
	{
		edit_name.clear();
		edit_name.sendKeys("Neelima Kawle");
	}

	public void click_continue(ChromeDriver driver)        
	{
	cont_btn.click();
	}
	
	public Edit_Profile(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
