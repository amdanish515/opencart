package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_AccountRegisteration extends BaseClass {

	@Test(groups = { "Smoke" })

	public void test_account_Registration() {
		logger.info("*********** starting application **********");
		try {
			HomePage hp = new HomePage(driver);
			hp.setMyAcntLoc();
			hp.setRegsiLoc();
			logger.info("************ opened application*********");
			RegisterPage rp = new RegisterPage(driver);
			rp.setFrstNameLoc(randomAlpha());
			rp.setlastNameLoc("Anihs");
			rp.setemailLoc(randomAlpha() + "@gmail.com");

			String randomAlphaPass = randomAlpha();

			rp.setpassLoc(randomAlphaPass);
			rp.setconfPassLoc(randomAlphaPass);
			rp.settelphnLoc("6545654");
			rp.setprivacyLoc();
			logger.info("*********** provided customer info *****************");
			rp.setconLoc();
			String setaccCreatMsgLoc = rp.setaccCreatMsgLoc();

			if (setaccCreatMsgLoc.equalsIgnoreCase("Your Account Has been Created!")) {
				Assert.assertTrue(true);
				logger.info("********** test passed ************");

			} else {
				logger.error("******* test failed ************");
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			Assert.fail();
		}
		{

		}
	}

}
