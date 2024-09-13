package amazon_source;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page {
	ChromeDriver driver;
	//step1
	@FindBy(id="addressChangeLinkId")     
	WebElement address_change_link;
	
	@FindBy(name="submissionURL")     
	WebElement address_radio_btn;
	
	@FindBy(id="shipToThisAddressButton")   
	WebElement use_this_address_btn;
	
	@FindBy(id="payChangeButtonId")           
	WebElement pay_change_link;
	
	@FindBy(name="ppw-widgetEvent:SetPaymentPlanSelectContinueEvent")   
	WebElement use_this_paymentmethod_btn;
	
	@FindBy(name="ppw-claimCode")  
	WebElement couponcode_tf;
	
	@FindBy(name="ppw-claimCodeApplyPressed")
	WebElement couponcode_apply_btn;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[1]") 
	WebElement pay_with_creditcard;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[2]") 
	WebElement pay_with_netbanking;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[3]") 
	WebElement pay_with_other_UPIApps;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[4]")  
	WebElement pay_on_EMI;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[5]") 
	WebElement pay_with_cash_on_delivery;
	
	@FindBy(xpath="//div[@class='checkout-chewbacca-contract-promise-content display-inline-block']/span/span/span")
	WebElement review_item_delivery;           
	
	//step2

	
	public void use_this_address_for_shipping()     
	{
		use_this_address_btn.click();
	}
	
	public void click_paychange_link()      
	{
		pay_change_link.click();
	}
	public void use_this_paymentmethod()  
	{
		use_this_paymentmethod_btn.click();
	}
	
	public WebElement addressChangeLink()  
	{
		return address_change_link;
	}
	
	public WebElement payChangeLink()     
	{
		return pay_change_link;
	}
	
	public WebElement reviewItemDelivery()       
	{
		return review_item_delivery;
	}
	
	public void enter_code(String code)
	{
		couponcode_tf.sendKeys(code+Keys.ENTER);
	}
	
	public void click_apply_code()
	{
	couponcode_apply_btn.click();
	}
	
	public WebElement creditcard_radiobutton()       
	{
		return pay_with_creditcard;
	}
	
	public WebElement netbanking_radiobutton()        
	{
		return pay_with_netbanking;
	}
	
	public WebElement otherUPIApps_radiobutton()       
	{
		return pay_with_other_UPIApps;
	}
	
	public WebElement emi_radiobutton()        
	{
		return pay_on_EMI;
	}
	

	public WebElement cashondelivery_radiobutton()        
	{
		return pay_with_cash_on_delivery;
	}
	
	
	//step3
	public Checkout_page(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
