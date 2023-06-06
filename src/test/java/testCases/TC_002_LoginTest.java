package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test
	public void test_login() {
		logger.info("******* starting TC_002_LoginTest *******");
		try {
			HomePage hp = new HomePage(driver);
			hp.setMyAcntLoc();
			hp.setloginLoc();
			LoginPage lp = new LoginPage(driver);
			lp.setemailLoc(rb.getString("email"));
			lp.setpassLoc(rb.getString("password"));
			lp.setclikLoc();

			MyAccountPage myp = new MyAccountPage(driver);
			boolean setmyacLoc = myp.setmyacLoc();
			Assert.assertEquals(setmyacLoc, true);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("********** finished TC_002_LoginTest *******");
	}

}
