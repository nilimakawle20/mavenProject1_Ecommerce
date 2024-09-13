package amazon_test;
//Test if a new user can successfully register.
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon_source.Homepage;
import amazon_source.Registrationpage;
@Listeners(utility.Listener1.class)
public class Test1_Registration extends LaunchQuit{
	@Test
	public void register_user() throws InterruptedException
	{
		Homepage h1=new Homepage(driver);
		h1.accountlist(driver);
		h1.register_link();
		
		Registrationpage r1=new Registrationpage(driver);
		r1.enter_custname();
		r1.enter_mobile_number();
		r1.enter_password();
		r1.verify_mobile_number();	
	}

}
