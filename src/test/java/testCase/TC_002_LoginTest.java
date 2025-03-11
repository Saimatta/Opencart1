package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePom;
import pageObject.LoginPom;
import pageObject.MyaccountPom;
import testBase.TestBase;

public class TC_002_LoginTest extends TestBase{
	
	
	@Test
	public void verifyLogin() {
		logger.info("*****TC_002_Login started *********");
		HomePom hp=new HomePom(driver);
		hp.clickonAccount();
		hp.clickonLogin();
		LoginPom lp=new LoginPom(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickOnLogin();
		
		MyaccountPom mp=new MyaccountPom(driver);
		boolean exp=mp.verifyCongMsg();
		Assert.assertTrue(exp);
	}

}
