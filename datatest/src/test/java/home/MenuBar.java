package home;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import resoures.Base;

public class MenuBar extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeClass
	public void testSetup() {
		parentTest=reports.createTest("TS002","Verify MenuBar functionality");
	}
	@BeforeMethod
	public void setup() throws IOException {
		driver=initializeDriver();
		loadPageObjets(driver);
	}
	@Test(priority=1, groups= {"Regression"})
	public void validateHomeButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("TC001", "Verify homepage button functionality in Menu ba");
		childTest.assignCategory("regression");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		boolean b =homePage.getHomeButton().isDisplayed();
		childTest.pass("check availability of HOME button");
		Assert.assertTrue(b);
		homePage.getHomeButton().click();
		childTest.pass("Click on HOME button");
		Assert.assertEquals(driver.getCurrentUrl().contains("index.php"), true, "Index page is not loaded");
		childTest.pass("verify that index page is loaded");
	}
	@Test(priority=2, groups= {"Sanity"})
	public void validateCoursesButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_2", "Verify Courses button functionality in Menu bar");
		childTest.assignCategory("regression");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		boolean b =homePage.getCoursesButton().isDisplayed();
		Assert.assertTrue(b);
		childTest.pass("Check availability of Courses button");
		System.out.println(homePage.getCoursesButton().getText());
		
		homePage.getCoursesButton().click();
		childTest.pass("Click on courses button");
		Assert.assertEquals(coursesPage.getPageTitle().getText().contains("COURSES"), true, "Courses page not loaded");
		childTest.pass("verify that courses page is loaded");
	}
	@Test(priority=3, groups= {"Regression"})
	public void validateVideosButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_3", "Verify Videos button functionality in Menu bar");
		childTest.assignCategory("regression");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		log.info("Navigated to HomePage");
		boolean b =homePage.getVideosButton().isDisplayed();
		Assert.assertTrue(b);
		childTest.pass("");
		System.out.println(homePage.getVideosButton().getText());
		homePage.getVideosButton().click();
		log.info("Menu button verified");
		System.out.println("");
	}
	@Test(priority=4, groups= {"Sanity"})
	public void validateInterviewGuideButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_4", "Verify Interview Guide button functionality in Menu bar");
		childTest.assignCategory("regression");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		log.info("Navigated to HomePage");
		boolean b =homePage.getInterviewGuideButton().isDisplayed();
		Assert.assertTrue(b);
		System.out.println(homePage.getInterviewGuideButton().getText());
		homePage.getInterviewGuideButton().click();
		log.info("Menu button verified");
	}
	@Test(priority=5, groups= {"Regression"})
	public void validatePracticeButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_5", "Verify Practice button functionality in Menu bar");
		childTest.assignCategory("sanity");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		log.info("Navigated to HomePage");
		boolean b =homePage.getPracticeButton().isDisplayed();
		Assert.assertTrue(b);
		System.out.println(homePage.getPracticeButton().getText());
		homePage.getPracticeButton().click();
		log.info("Menu button verified");
	}
	@Test(priority=6, groups= {"Sanity"})
	public void validateBlogButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_6", "Verify Blog button functionality in Menu bar");
		childTest.assignCategory("sanity");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		log.info("Navigated to HomePage");
		boolean b =homePage.getBlogButton().isDisplayed();
		Assert.assertTrue(b);
		System.out.println(homePage.getBlogButton().getText());
		homePage.getBlogButton().click();
		log.info("Menu button verified");
	}
	@Test(priority=7, groups= {"Regression"})
	public void validateAboutButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_7", "Verify About button functionality in Menu bar");
		childTest.assignCategory("sanity");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		log.info("Navigated to HomePage");
		boolean b =homePage.getAboutButton().isDisplayed();
		Assert.assertTrue(b);
		System.out.println(homePage.getAboutButton().getText());
		homePage.getAboutButton().click();
		log.info("Menu button verified");
	}
	@Test(priority=8, groups= {"Sanity"})
	public void validateContactButton() throws IOException, InterruptedException 
	{
		childTest=parentTest.createNode("testcase_8", "Verify Contact button functionality in Menu bar");
		childTest.assignCategory("sanity");
		driver.get(prop.getProperty("url"));
		childTest.pass("Navigate to URL");
		log.info("Navigated to HomePage");
		boolean b =homePage.getContactButton().isDisplayed();
		Assert.assertTrue(b);
		System.out.println(homePage.getContactButton().getText());
		homePage.getContactButton().click();
		log.info("Menu button verified");
	}

	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {

		String screenShot = captureScreen(driver, result);

		if (result.getStatus() == ITestResult.FAILURE) {
			//for (String s : Reporter.getOutput()) {
				//ExtentReporter.setTestRunnerOutput(s);
			//}
			//test.log(Status.FAIL, result.getName());
			childTest.log(Status.FAIL,result.getThrowable().getMessage());
			childTest.fail("Screen Shot : " + childTest.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(Status.PASS, result.getName());
			childTest.pass("Screen Shot : " + childTest.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			childTest.skip("Test Case : " + result.getName() + " has been skipped");
		}

		reports.flush();
		driver.close();
	}

}
