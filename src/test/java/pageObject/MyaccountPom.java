package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPom extends BasePom {
	public MyaccountPom(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id='content']/h2[1]")
	WebElement confmessage;
	
	
	public boolean verifyCongMsg() {
		try {
			return (confmessage.isDisplayed());
		}
		catch(Exception e){
			return false;
		}
	}
	
}
