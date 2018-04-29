package home;


import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


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
