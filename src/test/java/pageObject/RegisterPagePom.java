package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPagePom extends BasePom{

	public RegisterPagePom(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="firstname")
	WebElement lnkfirstName;
	
	@FindBy(name="lastname")
	WebElement lnklastName;
	
	@FindBy(name="email")
	WebElement lnkEmail;
	
	@FindBy(name="telephone")
	WebElement lnkTelephone;
	
	@FindBy(name="password")
	WebElement lnkPassword;
	
	@FindBy(name="confirm")
	WebElement lnkConfirmPass;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	WebElement lnkRadio;
	
	@FindBy(xpath = "//*[@name=\"agree\"]")
	WebElement lnkcheckBox;
	
	@FindBy(xpath = "//*[@value=\"Continue\"]")
	WebElement lnkContinue;
	
	
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement confmsg;
	
	public void setFirstName(String firstname) {
		lnkfirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		lnklastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		lnkEmail.sendKeys(email);
	}
	public void setTelephone(String tele) {
		lnkTelephone.sendKeys(tele);
	}
	
	public void setPassword(String password) {
		lnkPassword.sendKeys(password);
	}
	
	public void setconfirmPassword(String confirmPassword) {
		lnkConfirmPass.sendKeys(confirmPassword);
	}
	
	public void clickRadio() {
		lnkRadio.click();
	}
	
	public void clickcheck() {
		lnkcheckBox.click();
	}
	
	public void clickContinue() {
		lnkContinue.click();
	}
	public String getConfMsg() {
		return confmsg.getText();
	}
	
	

}
