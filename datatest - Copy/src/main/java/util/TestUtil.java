package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

public class TestUtil {

	public DateFormat dateFormat;
	public Date date;
	public String captureScreen(WebDriver driver, ITestResult result) throws IOException
	{
		 dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		 date = new Date();
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String screenName=result.getName()+"_"+dateFormat.format(date);
		String dest = System.getProperty("user.dir")+"//Test-Screenshots//"+screenName+".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}
	
	
}
