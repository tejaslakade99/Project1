package automation.Practise_Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObj.LoginPage;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	@Test
	public void Test1() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pratik\\.jenkins\\Practise_Project1\\webDriversSource\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Launching Web Browser");
		driver.get("https://www.qaclickacademy.com/");
		
		WebDriverWait W = new WebDriverWait(driver, 60);
		
	//	LandingPage lp = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		System.out.println("Wait untill Login Button field appears on sccreen");
		W.until(ExpectedConditions.elementToBeClickable(lp.login()));
		
		System.out.println("Clicking Login Button");
		lp.getemailid().click();
		
		driver.quit();
	}
   
}
