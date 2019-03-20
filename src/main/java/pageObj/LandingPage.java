/**
 * 
 */
package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Pratik
 *
 */
public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By login = By.cssSelector("a[href*='sign_in']");
	By popupNoThanks = By.xpath("//button[contains(.,'NO THANKS')]");
	// //div[@class='listbuilder-popup-scale']  //button[contains(.,'NO THANKS')]
	
	By PhoneNum = By.xpath("//span[contains(text(),'(+1) 323-744-6780')]");
	By getMenuBar = By.cssSelector(".nav");

	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement closepopup()
	{
		return driver.findElement(popupNoThanks);
	}
	
	public WebElement getPhoneNum()
	{
		return driver.findElement(PhoneNum);
	}
	
	public WebElement getMenuBar() {
		return driver.findElement(getMenuBar);
	}
}
