package qa.com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import qa.com.generic.InitializeEnvironment;

public class TestBase extends InitializeEnvironment{
	static Properties prop;
	InitializeEnvironment objInitializeEnvironment;
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
			    prop.load(fis);
			}
		catch(FileNotFoundException fi)
		{
			fi.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initializeWebEnvironment() {
			String browserName=prop.getProperty("browser");
			this.objInitializeEnvironment = new InitializeEnvironment();	
			this.objInitializeEnvironment.initializeWebEnvironment(browserName);
			driver.get(prop.getProperty("url"));
		
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public void takeScreenShotsFailScenario(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			//File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File file=ts.getScreenshotAs(OutputType.FILE);
			try
			{
				FileUtils.copyFile(file, new File("./HRMS_Fail_Screenshot/"+result.getName()+".png"));
				System.out.println("Screenshot taken");
				
			}
			catch(Exception e)
			{
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
	}
}
