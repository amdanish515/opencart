package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass(groups = {"Sanity", "Smoke"})
	@Parameters("browser")
	public void setUp(String br) {

		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());

		if (br.equalsIgnoreCase("chrome")) {
			logger.info("opened chrome browser");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(options);
		} else if (br.equalsIgnoreCase("edge")) {
			logger.info("edge browser");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));
	}

	@AfterClass(groups = {"Sanity", "Smoke"})
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		logger.info("************ closing the application*****************");
		driver.close();

	}

	public String randomAlpha() {
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(6);
		return randomAlphabetic;

	}

	public String randomNumeric() {
		String randomNumeric = RandomStringUtils.randomNumeric(5);
		return randomNumeric;

	}

	public String captureScreen(String tname) {
		Date dt = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyyMMddhhmmss");
		String timeStamp = simp.format(dt);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(screenshotAs, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
