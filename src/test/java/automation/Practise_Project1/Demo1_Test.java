/**
 * 
 */
package automation.Practise_Project1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger; //for .properties - apache.log4j.logger - logger object

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObj.LoginPage;
import pageObj.LandingPage;

/**
 * @author Pratik
 *
 */
public class Demo1_Test extends TestBase {

	// define log4j Logger

	final static Logger log = Logger.getLogger(Demo1_Test.class.getName()); // for log4j.properties file config

	@BeforeTest
	public void LaunchTest_DemoTestCase() throws IOException, InterruptedException {
		// declare local variables

		log.info("Launching Demo1_Test");
		
		readsetupprop();
		driver = LaunchWebBrowser();
log.info("Clone Commit to Remote");
		// Launch URL and maximize the window
		driver.get(URL);
		log.info("URL: " + URL + " Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(20);

	}

	@Test
	public void DemoTestCase() throws IOException {

		log.info("Running DemoTestCase");
		
		LandingPage l = new LandingPage(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		log.info("Implementing Wait - wait until Web Element appears on screen");
		WebDriverWait W = new WebDriverWait(driver, 120);

		// Wait until
		log.debug("Waiting until Web Element 'No Thanks' Appears");
		W.until(ExpectedConditions.elementToBeClickable(l.closepopup()));
		log.info("Web Element 'No Thanks' found");

		// Welcome Pop up
		log.debug("Clicking No Thanks");
		l.closepopup().click();
		
		//starting Login Steps

		log.debug("Clicking on Sign in");
		l.getLogin().click();

		// Redirecting to Login Page
		LoginPage lp = new LoginPage(driver);

		log.debug("Wait until Email ID Field appears on the Screen");
		W.until(ExpectedConditions.elementToBeClickable(lp.getemailid()));
		log.info("Success: Email ID field found");

		// Login form
		log.debug("Typing Email Id");
		lp.getemailid().sendKeys(prop.getProperty("Email"));
		log.info("Email ID input successful");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.debug("Typing Password");
		lp.getpwd().sendKeys(prop.getProperty("Password"));
		log.info("Password input successful");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.debug("Clicking Login button");
		lp.login().click();
		log.info("Login Button is Clicked successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		log.info("Test Case - DemoTestCase Completed");
	}

	@AfterTest
	public void TestQuit() throws IOException {
		log.info("Closing Driver and Window");

		teardown();
	}

}
