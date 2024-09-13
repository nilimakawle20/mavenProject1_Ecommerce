package amazon_test;
import org.testng.Assert;
//Ensure login fails with incorrect email or password.
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Login_Amazon;

@Listeners(utility.Listener1.class)
public class Test3_Loginwith_InvalidCredentials extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void Login_incorrect_UnPwd() throws InterruptedException
	{
	Homepage h1=new Homepage(driver);
	h1.accountlist(driver);
	h1.signin();

	Login_Amazon l1=new Login_Amazon(driver);
	l1.invalid_username();
	l1.cont();
	l1.invalid_password();
	l1.signin();
	
	Assert.assertEquals(driver.getTitle(), "Amazon Sign In", "Sorry please try again");
	}
}
