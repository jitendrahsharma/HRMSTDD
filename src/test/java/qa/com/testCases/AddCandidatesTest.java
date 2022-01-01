package qa.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.com.base.TestBase;
import qa.com.pages.CandidatesPage;
import qa.com.pages.HomePage;
import qa.com.pages.LoginPage;

public class AddCandidatesTest extends TestBase {
	
	HomePage objHomePage;
	LoginPage objLoginPage;
	TestBase objTestBase; 
	CandidatesPage objCandidatesPage;
	
	public AddCandidatesTest(){
		super();
	}
	
	@BeforeMethod
	public void initializeEnvironment() throws InterruptedException {
		objTestBase = new TestBase();
		objTestBase.initializeWebEnvironment();
		objLoginPage = new LoginPage();
		objHomePage= objLoginPage.login();
		objCandidatesPage = new CandidatesPage();
		
	}
	
	@Test
	public void addCandidate(){
		objHomePage.homeScreenDisplayed();
		objHomePage.clickOnMenu("Recruitment", "Candidates", "");
		objCandidatesPage.clickOnaddBtn();
		objCandidatesPage.setFirstName("Vinay");
		objCandidatesPage.setLastName("Kumar");
		objCandidatesPage.setEmailId("vinaykumar@gmail.com");
		objCandidatesPage.setContactNo("7876789612");
		objCandidatesPage.selectJobVacancy("Software Engineer");
		objCandidatesPage.uploadResume("E:/HRMSTDD/src/test/resources/Documents/XXXXX.pdf");
		objCandidatesPage.selectDate("10","Dec","2021");
		objCandidatesPage.clickOnConsentCheckBox();
		objCandidatesPage.clickOnSaveBtn();
		
	}
	
	@AfterMethod
	public void tearDownEnvironment(){
		TestBase.quitBrowser();
	}
	

}
