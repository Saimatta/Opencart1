package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePom extends BasePom{

	public HomePom(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[text()='My Account']")
	WebElement lnkmyAccount;
	
	
	@FindBy(xpath = "//*[text()='Register']")
	WebElement lnkRegisterbtn;
	
	
	@FindBy(xpath = "//*[text()='Login']")
	WebElement lnkLogin;
	
	public void clickonAccount() {
		lnkmyAccount.click();
	}
	
	public void clickonRegister() {
		lnkRegisterbtn.click();
	}
	
	public void clickonLogin() {
		lnkLogin.click();
	}

}
