package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CoursesPage {
	WebDriver driver;
	public CoursesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-sm-12 text-center']")
	WebElement pageTitle;
	
	public WebElement getPageTitle()
	{
		return pageTitle;
	}
}
