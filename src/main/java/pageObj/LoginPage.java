/**
 * 
 */
package pageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Pratik
 *
 */
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//input[contains(@value,'Log In')]")
	WebElement Login;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div[1]/div/div")
	WebElement Login_Response;
	
	public WebElement getemailid()
	{
		return emailid;
		
	}
	
	public WebElement getpwd()
	{
		return pwd;
	}

	public WebElement login()
	{
		return Login;
	}
	public WebElement getLogin_Response()
	{
		return Login_Response;
		
	}
}
