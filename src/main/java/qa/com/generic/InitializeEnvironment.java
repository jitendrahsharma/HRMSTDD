package qa.com.generic;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;

import io.github.bonigarcia.wdm.WebDriverManager;



public class InitializeEnvironment{
	
	public static  WebDriver driver;
	private static  Properties prop;
	
	/**
     * @author Jitendra.Sharma
     * @since 14 Oct 2021
     * @description This Method is used to initial the driver
     * @param browser
     * @return this method will return tlDriver
     */
	public void  initializeWebEnvironment(String browserName){		
		try {
			System.out.println("Browser value is "+ browserName);
			switch (browserName) {
			case "chrome":
				WebDriverManager.chromiumdriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				options.addArguments("--window-size=1366,768");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver();
				break;
			case "firefox": 
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				break;
			case "dockerchrome":
				options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				options.addArguments("--headless");
				BrowserWebDriverContainer chromeContainer = new BrowserWebDriverContainer("selenium/standalone-chrome-debug");
				Thread.sleep(20000);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				chromeContainer = chromeContainer.withCapabilities(capabilities);
				chromeContainer.start();
				chromeContainer.getContainerId();
				driver = chromeContainer.getWebDriver();
				System.out.println("Starting RemoteChrome Driver throught docker testcontainer");
				break;
			}
			driver.manage().deleteAllCookies();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			}
				catch (Exception exception) {
					exception.printStackTrace();
			}
			
	}
	
}
