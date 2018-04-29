package home;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resoures.Base;



public class HomePageNavigation extends Base{
	
	@BeforeClass
	public void testSetup() {
		parentTest=reports.createTest("TS001","Verify Login functionality");
	}
	@BeforeMethod
	public void setup() throws IOException {
		driver=initializeDriver();
		loadPageObjets(driver);
		childTest=parentTest.createNode("TC001", "validate login functionality with valid use ID and ped");
	}
	
	@Test(dataProvider="getData")
	public void basepage_navigation(String username, String password) throws IOException
	{
				
		grandChildTest=childTest.createNode("testcase_1", "base page navigation");
		grandChildTest.assignCategory("sanity");
		driver.get(prop.getProperty("url"));
		grandChildTest.pass("Navigate to URL: "+prop.getProperty("url"));
		
		homePage.getLogin().click();
		grandChildTest.pass("Click on Login link");
		
		loginPage.enterEmail().sendKeys(username);
		grandChildTest.pass("Enter Username: "+username);
		
		loginPage.enterPassword().sendKeys(password);
		grandChildTest.pass("Enter password: "+password);
		
		loginPage.clickLogin().click();
		grandChildTest.pass("Clik on login button");
		
		grandChildTest.pass("Expected Results: Error messege should be displayed");
		Assert.assertEquals(loginPage.errorMsg().getText(), "Invalid email or password");
		grandChildTest.pass("Expeted Result: Invalid email or password -- Actual Result: "+loginPage.errorMsg().getText());
		
		
	}
	
	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {

		String screenShot = captureScreen(driver, result);

		if (result.getStatus() == ITestResult.FAILURE) {
			childTest.log(Status.FAIL, result.getName());
			childTest.log(Status.FAIL,result.getThrowable());
			childTest.fail("Screen Shot : " + childTest.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			childTest.log(Status.PASS, result.getName());
			childTest.pass("Screen Shot : " + childTest.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			childTest.skip("Test Case : " + result.getName() + " has been skipped");
		}

		reports.flush();
		driver.close();
	}
	@AfterClass
	public void closeup() {
		reports.flush();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		data[0][0]="uday@hmail.com";
		data[0][1]="password1";
		data[1][0]="udaykumar@gmail.com";
		data[1][1]="password2";
		return data;
	}
}
