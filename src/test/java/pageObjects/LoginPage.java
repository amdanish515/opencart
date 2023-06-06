package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@CacheLookup
	@FindBy(id="input-email")
	WebElement emailLoc;
	
	@CacheLookup
	@FindBy(id="input-password")
	WebElement passLoc;
	
	@CacheLookup
	@FindBy(xpath="//input[@type='submit']")
	WebElement clikLoc;
	
	
	public void setemailLoc(String email) {
		emailLoc.sendKeys(email);

	}
	
	public void setpassLoc(String pass) {
		passLoc.sendKeys(pass);

	}
	public void setclikLoc() {
		clikLoc.click();

	}
}
