package home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import resoures.Base;

public class BaseTestSuite extends Base{
	
	
	@BeforeSuite
    public void startSuite(ITestContext ctx)
    {
		suiteName=ctx.getSuite().getName();
    	Base.initReports(suiteName);
    	
    	}
	@AfterSuite
	public void endSuite()
	{
		reports.flush();
	}
	

}
