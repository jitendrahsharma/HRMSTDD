package qa.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import qa.com.base.TestBase;
import qa.com.pages.HomePage;
import qa.com.pages.LoginPage;

public class HomePageTest extends TestBase{
HomePage objHomePage;
LoginPage objLoginPage;
TestBase objTestBase;

public HomePageTest ()
{
	super();
}

@BeforeMethod
	public void initializeEnvironment() throws InterruptedException {
		objTestBase = new TestBase();
		objTestBase.initializeWebEnvironment();
		objLoginPage = new LoginPage();
		objHomePage= objLoginPage.login();
	}

	
	@Test
	public void verifyHomePageTitle() throws InterruptedException{
		objHomePage.homeScreenDisplayed();
	}
	
	@AfterMethod
	public void tearDownEnvironment(){
		TestBase.quitBrowser();
	}

}
