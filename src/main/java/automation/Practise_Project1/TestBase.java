/**
 * 
 */
package automation.Practise_Project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pratik
 *
 */
public class TestBase {

	// Define log4j.xml Logger
	// private static Logger log = LogManager.getLogger(TestBase.class.getName());

	// for log4j.properties file config
	final static Logger log = Logger.getLogger(TestBase.class.getName());

	// define local/global variables
	public static WebDriver driver = null;
	public FileInputStream fis = null;
	public String setup_prop = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\resources\\setup.properties";
	public Properties prop = new Properties();
	public String Browser = null;
	public String URL = null;
	public String targetDirss = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\TestResults-Screenshots\\";
	

	public void readsetupprop() {
		// load setup.properties file in 'fis'
		log.debug("Trying to read setup.properties from System/Project path :" + setup_prop);

		try {
			fis = new FileInputStream(setup_prop);
			try {
				prop.load(fis);
				log.info("setup.properties file has been loaded successfully!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("setup.properties failed to load in File Input Stream Object!!!");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("setup.properties file Not Found at specified Location :" + setup_prop);
			e.printStackTrace();
		}

		// read File Input Stream
		log.debug("Trying to read Browser Name and Application URL from setup.properties");
		Browser = prop.getProperty("Browser");
		URL = prop.getProperty("webURL");
		log.info("Web Browser Option: " + Browser + " :: Application URL: " + URL);

	}

	public WebDriver LaunchWebBrowser() {

		// declare and define webdriver server .exe path
		String Chromepath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\chromedriver.exe";
		String IEpath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\IEDriverServer.exe";
		String FFpath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\geckodriver.exe";
		String Edgepath = "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\MicrosoftWebDriver.exe";

		// Launching WebDriver as per Browser Name in setup.properties file

		switch (Browser) {

		case "1":
			System.setProperty("webdriver.chrome.driver", Chromepath);
			driver = new ChromeDriver();
			log.info("Google Chrome is getting launched");
			break;

		case "2":
			System.setProperty("webdriver.ie.driver", IEpath);
			driver = new InternetExplorerDriver();
			log.info("Internet Explorer is getting launched");
			break;

		case "3":
			System.setProperty("webdriver.gecko.driver", FFpath);
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					"C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\logs\\FireFox_Internal_logs.txt");
			driver = new FirefoxDriver();
			log.info("Mozilla Firefox is getting launched");

			break;
		case "4":
			System.setProperty("webdriver.edge.driver", Edgepath);
			driver = new EdgeDriver();
			log.info("Microsoft Edge is getting launched");
			break;

		default:
			log.error("Failed to Launch Web Browser: Invalid Web Browser Value is configured in setup.properties");

		}

		return driver;
	}

	public void teardown() {
		log.debug("Quitting WebDriver");
		driver.quit();
		log.info("Web Driver closed");
	}

	public void getScreenshot(String TestCaseName) {
		log.debug("Capturing Screenshot..");
		File screenprint = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			log.debug("Copying screenshot to target directory :" + targetDirss);
			FileUtils.copyFile(screenprint, new File(targetDirss + TestCaseName + System.currentTimeMillis() + ".png"));
			log.info("Screenshot captured and stored");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Screenshot got captured but failed to transfer at target directory");
			e.printStackTrace();
		}
	}

	public WebDriverWait waituntil() {
		// implementing Wait Until
		WebDriverWait W = new WebDriverWait(driver, 60);
		return W;
	}

	
}
