package home;

import java.io.IOException;


import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import resoures.Base;



public class HomePageNavigation extends Base{
	
	@BeforeClass(groups= {"Regression", "Sanity"})
	public void testSetup() {
		parentTest=reports.createTest("TS001","Verify Login functionality");
	}
	@BeforeMethod(groups= {"Regression", "Sanity"})
	public void setup() throws IOException {
		driver=initializeDriver();
		loadPageObjets(driver);
		
	}
	
	@Test(dataProvider="getData", groups= {"Regression", "Sanity"})
	public void basepage_navigation(String username, String password) throws IOException
	{
		childTest=parentTest.createNode("TC001", "validate login functionality with valid use ID and ped");
		
		childTest.assignCategory("sanity");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL: "+prop.getProperty("url"));
		
		homePage.getLogin().click();
		childTest.pass("Click on Login link");
		
		loginPage.enterEmail().sendKeys(username);
		childTest.pass("Enter Username: "+username);
		
		loginPage.enterPassword().sendKeys(password);
		childTest.pass("Enter password: "+password);
		
		loginPage.clickLogin().click();
		childTest.pass("Clik on login button");
		
		childTest.pass("Expected Results: Error messege should be displayed");
		Assert.assertEquals(loginPage.errorMsg().getText(), "Invalid email or password");
		childTest.pass("Expeted Result: Invalid email or password -- Actual Result: "+loginPage.errorMsg().getText());
		
		
	}
	
	@AfterMethod(groups= {"Regression", "Sanity"})
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
	@AfterClass(groups= {"Regression", "Sanity"})
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
