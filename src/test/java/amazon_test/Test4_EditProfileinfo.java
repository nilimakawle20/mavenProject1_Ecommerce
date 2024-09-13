package amazon_test;
// Check if a user can successfully edit their profile information.
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Edit_Profile;
import amazon_source.Homepage;
import amazon_source.Login_Amazon;
import utility.DDT;

@Listeners(utility.Listener1.class)
public class Test4_EditProfileinfo extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void edit_profile_details() throws EncryptedDocumentException, IOException, InterruptedException
	{
	Homepage h1=new Homepage(driver);
	h1.accountlist(driver);
	h1.signin();
	
	DDT d=new DDT();
	d.credentials();
	
	Login_Amazon l1=new Login_Amazon(driver);
	l1.enter_username();
	l1.cont();
	l1.enter_password();
	l1.signin();
	
	Edit_Profile e1=new Edit_Profile(driver);
	e1.accountlist_hover(driver);
	e1.clickon_accountholder();
	e1.click_view_button();
	e1.click_edit_profile();
	e1.backspace_profile_name();
	e1.click_continue(driver);
	}
}
