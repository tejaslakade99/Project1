/**
 * 
 */
package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.Practise_Project1.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObj.LandingPage;
import pageObj.LoginPage;

/**
 * @author Pratik
 *
 */
@RunWith(Cucumber.class)
public class StepDefinition_QAClick {

	// for log4j.properties file config
	final static Logger log = Logger.getLogger(TestBase.class.getName());

	private String Login_response = null;

	public static WebDriver driver = null;
	public String targetDirss = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\TestResults-Screenshots\\";

	@Given("^Initialize \"([^\"]*)\" webdriver$")
	public void initialize_something_webdriver(String strArg1) throws Throwable {
		log.info("WebDriver Initialize Step: " + strArg1);

		// declare and define webdriver server .exe path
		String Chromepath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\chromedriver.exe";
		String IEpath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\IEDriverServer.exe";
		String FFpath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\geckodriver.exe";
		String Edgepath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\MicrosoftWebDriver.exe";

		// Launching WebDriver as per Browser Name in setup.properties file

		switch (strArg1) {

		case "Google Chrome":
			System.setProperty("webdriver.chrome.driver", Chromepath);
			driver = new ChromeDriver();
			log.info("Google Chrome is getting launched");
			break;

		case "Internet Explorer":
			System.setProperty("webdriver.ie.driver", IEpath);
			driver = new InternetExplorerDriver();
			log.info("Internet Explorer is getting launched");
			break;

		case "Mozilla Firefox":
			System.setProperty("webdriver.gecko.driver", FFpath);
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					"C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\logs\\FireFox_Internal_logs.txt");
			driver = new FirefoxDriver();
			log.info("Mozilla Firefox is getting launched");

			break;
		case "Microsoft Edge":
			System.setProperty("webdriver.edge.driver", Edgepath);
			driver = new EdgeDriver();
			log.info("Microsoft Edge is getting launched");
			break;

		default:
			log.error("Failed to Launch Web Browser: Invalid Web Browser Value is configured in setup.properties");
			log.error("Correct values to be used for Web Browser are: " + "\n" + "Google Chrome" + "\n"
					+ "Internet Explorer" + "\n" + "Mozilla Firefox" + "\n" + "Microsoft Edge");

		}

	}

	@When("^User Clicks on \"([^\"]*)\" hyperlink$")
	public void user_clicks_on_something_hyperlink(String strArg1) throws Throwable {
		log.info("Click Login Step");

		LandingPage l = new LandingPage(driver);

		log.info("Implementing Wait - wait until Web Element appears on screen");
		WebDriverWait W = new WebDriverWait(driver, 120);

		// Wait until
		log.debug("Waiting until Web Element 'No Thanks' Appears");
		W.until(ExpectedConditions.elementToBeClickable(l.closepopup()));
		log.info("Web Element 'No Thanks' found");

		// Welcome Pop up
		log.debug("Clicking No Thanks");
		l.closepopup().click();

		log.debug("Clicking on Sign in");
		l.getLogin().click();
		log.info("Success: Click");
	}

	@Then("^User gets redirected to \"([^\"]*)\" Screen having \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" Web Elements present$")
	public void user_gets_redirected_to_something_screen_having_something_something_and_something_web_elements_present(
			String strArg1, String strArg2, String strArg3, String strArg4) throws Throwable {
		log.info("Redirect to Login Page Step");

		LoginPage lp = new LoginPage(driver);

		log.info("Implementing Wait - wait until Web Element appears on screen");
		WebDriverWait W = new WebDriverWait(driver, 120);

		log.debug("Wait until Email ID Field appears on the Screen");
		W.until(ExpectedConditions.elementToBeClickable(lp.getemailid()));
		log.info("Success: Email ID field found");

		log.debug("Wait until Password Field appears on the Screen");
		W.until(ExpectedConditions.elementToBeClickable(lp.getpwd()));
		log.info("Success: Password field found");

		log.debug("Wait until Login Button appears on the Screen");
		W.until(ExpectedConditions.elementToBeClickable(lp.login()));
		log.info("Success: Log In Button found");

	}

	@And("^Launch \"([^\"]*)\" URL$")
	public void launch_something_url(String strArg1) throws Throwable {
		log.info("Launch URL Step" + strArg1);

		driver.get(strArg1);
		log.info("URL: " + strArg1 + " Launched");
		log.info("Waiting for 20 Seconds");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Then("User populates Email Address as {string} ,  Password as {string} and Clicks {string} Button")
	public void user_populates_Email_Address_as_Password_as_and_Clicks_Button(String email, String password, String strArg1) throws Throwable {

		log.info("fill Login form and Click " + strArg1);

		LoginPage lp = new LoginPage(driver);

		WebDriverWait W = new WebDriverWait(driver, 120);
		log.debug("Wait until Email ID Field appears on the Screen");
		W.until(ExpectedConditions.elementToBeClickable(lp.getemailid()));
		log.info("Success: Email ID field found");

		// Login form
		log.debug("Typing Email Id");
		lp.getemailid().sendKeys(email);
		log.info("Email ID input successful");

		log.debug("Typing Password");
		lp.getpwd().sendKeys(password);
		log.info("Password input successful");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("Clicking Login button");
		lp.login().click();
		log.info("Login Button is Clicked successfully");

	}

	@And("^User Login Failed$")
	public void user_login_failed() {

		LoginPage lp = new LoginPage(driver);
		Login_response = lp.getLogin_Response().getText();
		Assert.assertTrue(Login_response.equalsIgnoreCase("Invalid email or password."));
		log.info("Login Failed with Error Message : " + Login_response);
	}

/*	public void getScreenshot() {
		log.debug("Capturing Screenshot..");
		File screenprint = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			log.debug("Copying screenshot to target directory :" + targetDirss);
			FileUtils.copyFile(screenprint, new File(targetDirss + "TestExecution" + System.currentTimeMillis() + ".png"));
			log.info("Screenshot captured and stored");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Screenshot got captured but failed to transfer at target directory");
			e.printStackTrace();
		}
	}*/
@After
	public void teardown() {
		log.info("Closing Web driver");
		StepDefinition_QAClick.driver.quit();
		log.info("Success");
	}
}
