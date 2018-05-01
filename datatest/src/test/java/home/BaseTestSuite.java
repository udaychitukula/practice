package home;


import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import resoures.Base;

public class BaseTestSuite extends Base{
	
	
	@BeforeSuite(groups= {"Regression", "Sanity"})
    public void startSuite(ITestContext ctx)
    {
		suiteName=ctx.getSuite().getName();
    	Base.initReports(suiteName);
    	
    	}
	@AfterSuite(groups= {"Regression", "Sanity"})
	public void endSuite()
	{
		reports.flush();
	}
	

}
