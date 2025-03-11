package testCase;

import java.lang.System.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePom;
import pageObject.RegisterPagePom;
import testBase.TestBase;

public class TC_001_Registration extends TestBase{
	@Test
	void verifyRegister(){
		try {
		logger.info("********** Application Started **********");
		HomePom hp=new HomePom(driver);
		logger.info("******Clicking on MyAccount**********");
		hp.clickonAccount();
		hp.clickonRegister();
		String pass=getrandompass();
		RegisterPagePom rp=new RegisterPagePom(driver);
		rp.setFirstName(getrandomstring());
		rp.setLastName(getrandomstring());
		rp.setEmail(getRandomemail());
		rp.setTelephone(getRandomNumber());
		rp.setPassword(pass);
		rp.setconfirmPassword(pass);
		rp.clickRadio();
		rp.clickcheck();
		rp.clickContinue();
		String actual="Your Account Has Been Created!";
		String exp=rp.getConfMsg();
		if(exp.equals(actual)) {
			logger.info("Test passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Test failed");
			logger.debug("Boggu");
			Assert.fail();
		}
		}catch(Exception e) {
			logger.trace("Sai");
		}
	}
	

	

}
