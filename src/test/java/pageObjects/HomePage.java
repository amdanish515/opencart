package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage { 

	//public WebDriver driver;

	
	//Constructor 
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	public HomePage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}

	
	//Locators
	@CacheLookup
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAcntLoc;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Register']")
	WebElement regsiLoc;

	
	@CacheLookup
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLoc;
	//Action methods
	public void setMyAcntLoc() {
		myAcntLoc.click();
	}

	public void setRegsiLoc() {
		Actions a = new Actions(driver);
		a.moveToElement(regsiLoc).click().build().perform();
	}
	
	public void setloginLoc() {
		loginLoc.click();

	}
}
