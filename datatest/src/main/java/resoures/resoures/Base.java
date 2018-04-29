package resoures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.CoursesPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.TestUtil;

public class Base extends TestUtil{

	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	public static ExtentTest grandChildTest;
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	public static final Date date = new Date();
	
	public HomePage homePage;
	public LoginPage loginPage;
	public CoursesPage coursesPage;
	public WebDriver driver;
	public Properties prop = new Properties();
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public String suiteName;
	
	public static void initReports(String suiteName)
	{
		reports = new ExtentReports();
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-reports//"+suiteName+"-report "+dateFormat.format(date)+".html");
    	reports.attachReporter(htmlReporter);
    	
    	reports.setSystemInfo("Machine", "Uday-123");
    	reports.setSystemInfo("Browser", "FireFox");
    	reports.setSystemInfo("Host Name", "SoftwareTestingMaterial");
    	reports.setSystemInfo("Environment", "Automation Testing");
	}
	
	public WebDriver initializeDriver() throws IOException
	{
		
		//FileInputStream fs = new FileInputStream("C:\\Users\\UDAY\\datatest\\src\\main\\java\\resoures\\data.properties");
		FileInputStream fs = new FileInputStream("./src/main/java/resoures/data.properties");
		prop.load(fs);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox"))
		{
			
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	public void loadPageObjets(WebDriver driver)
	{
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		coursesPage=new CoursesPage(driver);
	}
	
	
}
