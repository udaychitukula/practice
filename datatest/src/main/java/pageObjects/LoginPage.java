package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	WebElement email;
	@FindBy(id="user_password")
	WebElement password;
	@FindBy(xpath=".//*[@name='commit' and @type='submit']")
	WebElement login;
	@FindBy(xpath="html/body/div[1]/div[1]/div/div/div/div/div[1]/div/div")
	WebElement errorMsg;
	
	public WebElement enterEmail()
	{
		return email;
	}
	public WebElement enterPassword()
	{
		return password;
	}
	public WebElement clickLogin()
	{
		return login;
	}
	public WebElement errorMsg()
	{
		return errorMsg;
	}
	
	
}
