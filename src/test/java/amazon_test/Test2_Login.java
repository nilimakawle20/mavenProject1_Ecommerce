package amazon_test;
//Verify login is successful with correct email and password.
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Login_Amazon;
import utility.DDT;

@Listeners(utility.Listener1.class)
public class Test2_Login extends LaunchQuit{
	@Test(retryAnalyzer=utility.RetryLogic.class)
	public void Login_to_Amazon() throws InterruptedException, EncryptedDocumentException, IOException
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
	}

}
