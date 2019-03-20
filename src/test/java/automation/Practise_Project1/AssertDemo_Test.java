package automation.Practise_Project1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger; //for .properties - apache.log4j.logger - logger object


//import org.apache.logging.log4j.LogManager; //for xml - logging.log4j -- LogManager object
//import org.apache.logging.log4j.Logger; //for xml - logging.log4j-- LogManager object

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObj.LandingPage;

public class AssertDemo_Test extends TestBase {
	// define log4j Logger

	final static Logger log = Logger.getLogger(Demo1_Test.class.getName()); // for log4j.properties file config

	@BeforeTest
	public void LaunchTest_AssertDemo() throws InterruptedException {
		// declare local variables

		log.info("Launching assertDemo");

		readsetupprop();
		driver = LaunchWebBrowser();

		// Launch URL and maximize the window
		driver.get(URL);
		log.info("URL: " + URL + " Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(30);

	}

	@Test
	public void AssertTestCase() throws IOException, InterruptedException {

		// declare local variables
		log.info("Running assertDemo-->AssertTestCase");
		String ExpectedPhoneNum = "(+1) 323-744-6780";

		LandingPage l = new LandingPage(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(30);
		log.info("Implementing Wait - wait until Web Element appears on screen");
		WebDriverWait W = new WebDriverWait(driver, 120);

		// Wait until
		log.debug("Waiting until Web Element 'No Thanks' Appears");
		
		
		W.until(ExpectedConditions.elementToBeClickable(l.closepopup()));
		log.info("Web Element 'No Thanks' found");

		// Welcome Popup
		log.debug("Clicking No Thanks");
		l.closepopup().click();

		// Assertions - Validations using Assertions

		log.debug("Assert: Compare - actual Phone Num vs Expected Phone Num");
		Assert.assertEquals(l.getPhoneNum().getText(), ExpectedPhoneNum, "Phone Number doesn't match");
		log.info("Assert is completed for Phone compare");

		log.debug("Verify if menu is present on page");
		Assert.assertTrue(l.getMenuBar().isDisplayed(), "MenuBar is not displayed");
		log.info("Assert is completed for MenuBar display");

	}

	@AfterTest
	public void TestQuit() throws IOException {
		teardown();
	}

}
