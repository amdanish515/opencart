package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@CacheLookup
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myacLoc;
	
	@CacheLookup
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logoutLoc;

	public boolean setmyacLoc() {

		try {
			return (myacLoc.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public void setlogoutLoc() {
		logoutLoc.click();

	}

}
