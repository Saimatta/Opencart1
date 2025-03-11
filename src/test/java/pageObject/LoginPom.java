package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPom extends BasePom {
	
	public LoginPom(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "input-email")
	WebElement lEmail;
	
	@FindBy(id = "input-password")
	WebElement lpassword;
	
	@FindBy(xpath = "//*[@value='Login']")
	WebElement clkLogin;
	
	
	
	public void setEmail(String email) {
		lEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		lpassword.sendKeys(password);
		
	}
	
	public void clickOnLogin() {
		clkLogin.click();
	}

}
