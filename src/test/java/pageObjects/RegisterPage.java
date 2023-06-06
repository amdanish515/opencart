package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@CacheLookup
	@FindBy(name = "firstname")
	WebElement frstNameLoc;

	@CacheLookup
	@FindBy(id = "input-lastname")
	WebElement lastNameLoc;

	@CacheLookup
	@FindBy(id = "input-email")
	WebElement emailLoc;

	@CacheLookup
	@FindBy(id = "input-telephone")
	WebElement telphnLoc;

	@CacheLookup
	@FindBy(id = "input-password")
	WebElement passLoc;

	@CacheLookup
	@FindBy(id = "input-confirm")
	WebElement confPassLoc;

	@CacheLookup
	@FindBy(xpath = "//input[@type='submit']")
	WebElement conLoc;

	@CacheLookup
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement privacyLoc;

	@CacheLookup
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement accCreatMsgLoc;

	public void setFrstNameLoc(String frstName) {
		frstNameLoc.sendKeys(frstName);
	}

	public void setlastNameLoc(String lastname) {
		lastNameLoc.sendKeys(lastname);

	}

	public void setemailLoc(String email) {
		emailLoc.sendKeys(email);

	}

	public void settelphnLoc(String phnNum) {
		telphnLoc.sendKeys(phnNum);

	}

	public void setpassLoc(String pass) {
		passLoc.sendKeys(pass);

	}

	public void setconfPassLoc(String confPass) {
		confPassLoc.sendKeys(confPass);

	}

	public void setconLoc() {
		conLoc.click();

	}

	public void setprivacyLoc() {
		privacyLoc.click();

	}

	public String setaccCreatMsgLoc() {
		String text = accCreatMsgLoc.getText();
		System.out.println(text);
		return text;
	}

}
