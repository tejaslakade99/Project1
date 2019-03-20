package automation.Practise_Project1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.Practise_Project1.DataBase_conn;
import pageObj.LandingPage;
import pageObj.LoginPage;

/**
 * 
 */

/**
 * @author Pratik
 *
 */
public class DB_Test extends TestBase {

	// Initializing log4j.properties file
	final static Logger log = Logger.getLogger(DB_Test.class.getName());

	// Initializing Data Base COnnnection Object
	DataBase_conn conn = new DataBase_conn();
	Demo1_Test WT = new Demo1_Test();
	Statement s = null;
	ResultSet rs = null;

	@BeforeTest
	public void Launch_DBTest() {

		/*
		 * Establishing Database Statement Object
		 */
		log.info("Preparing to launch DB COnnection Test");

		s = conn.connect_mySQL_DB();
		
		//initializing Web Driver
		readsetupprop();
		driver = LaunchWebBrowser();
	}

	@Test
	public void DBconnTest() throws SQLException {

		log.info("Test Case : DB Connection");
		rs = s.executeQuery("Select * FROM Project1.EmployeeInfo WHERE Employee_ID = 0001");
		// By Default - ResultSet stores the Query result for very first time at 1st
		// index

		rs.next();
		// DB Table values can be displayed by referencing table column name

		log.debug("Displaying Table Data for the Query Statement");
		log.info("Employee Name :" + rs.getString("Employee_Name"));
		log.info("Employee ID :" + rs.getString("Employee_ID"));
		log.info("Location :" + rs.getString("Location"));
		log.info("Age :" + rs.getString("Age"));
	}

	@Test
	public void webdriver_test() throws IOException, InterruptedException, SQLException {
		log.info("Launching WebDriver test using Data from DB table");

		
		driver.get(URL);
		log.info("URL: " + URL + " Launched");
		driver.manage().window().maximize();
		
		
		log.info("Running Web Driver test");

		LandingPage l = new LandingPage(driver);

		log.info("Implementing Wait - wait until Web Element appears on screen");
		WebDriverWait W = new WebDriverWait(driver, 120);

		// Wait until
		log.debug("Waiting until Web Element 'No Thanks' Appears");
		
		log.debug("Waiting for 20 Seconds");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		W.until(ExpectedConditions.elementToBeClickable(l.closepopup()));
		log.info("Web Element 'No Thanks' found");

		// Welcome Pop up
		log.debug("Clicking No Thanks");
		l.closepopup().click();

		// starting Login Steps

		log.debug("Clicking on Sign in");
		l.getLogin().click();

		// Redirecting to Login Page
		LoginPage lp = new LoginPage(driver);

		log.debug("Wait until Email ID Field appears on the Screen");
		W.until(ExpectedConditions.elementToBeClickable(lp.getemailid()));
		log.info("Success: Email ID field found");

		// Login form
		log.debug("Typing Email Id");
		lp.getemailid().sendKeys(rs.getString("Employee_Name"));
		log.info("Email ID input successful");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.debug("Typing Password");
		lp.getpwd().sendKeys(rs.getString("Employee_ID"));
		log.info("Password input successful");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.debug("Clicking Login button");
		lp.login().click();
		log.info("Login Button is Clicked successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		log.info("Test Case - DemoTestCase Completed");
		

	}

	@AfterTest
	public void Close_DBTest() throws SQLException {

		log.debug("Closing JDBC driver connction to MYSQL Database");
		conn.closeDBConnection();
		log.info("Success: JDBC Connection Closed");
		
		log.debug("Quitting Web Driver");
		teardown();
	}

}
