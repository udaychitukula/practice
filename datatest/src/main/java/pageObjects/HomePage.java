package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	By login= By.xpath(".//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a/span");
	By contentTitle=By.cssSelector(".text-center>h2");
	By popup=By.xpath(".//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]");
	//By homeButton=By.xpath("//a[@href='index.php']");
	By homeButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[1]/a");
	By coursesButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[2]/a");
	By videosButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[3]/a");
	By interviewGuideButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[4]/a");
	By praticeButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[5]/a");
	By blogButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[6]/a");
	By aboutButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[7]/a");
	By contactButton=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[8]/a");
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getcontentTitle()
	{
		return driver.findElement(contentTitle);
	}
	
	public WebElement getHomeButton()
	{
		return driver.findElement(homeButton);
	}
	public WebElement getCoursesButton()
	{
		return driver.findElement(coursesButton);
	}
	public WebElement getVideosButton()
	{
		return driver.findElement(videosButton);
	}
	public WebElement getInterviewGuideButton()
	{
		return driver.findElement(interviewGuideButton);
	}
	public WebElement getPracticeButton()
	{
		return driver.findElement(praticeButton);
	}
	public WebElement getBlogButton()
	{
		return driver.findElement(blogButton);
	}
	public WebElement getAboutButton()
	{
		return driver.findElement(aboutButton);
	}
	public WebElement getContactButton()
	{
		return driver.findElement(contactButton);
	}
}
