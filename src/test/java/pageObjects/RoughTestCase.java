package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RoughTestCase {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void reg() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setMyAcntLoc();
		h.setRegsiLoc();
		RegisterPage r = new RegisterPage(driver);
		r.setFrstNameLoc("Mohammed");
		r.setlastNameLoc("Anish");
		r.settelphnLoc("98774545");
		r.setemailLoc("asds4sfdfsef@gmail.com");
		r.setpassLoc("asdfghfge");
		r.setconfPassLoc("asdfghfge");
		r.setprivacyLoc();
		r.setconLoc();
		
		Thread.sleep(1000);
		String setaccCreatMsgLoc = r.setaccCreatMsgLoc();
		//System.out.println(setaccCreatMsgLoc);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();

	}
}
