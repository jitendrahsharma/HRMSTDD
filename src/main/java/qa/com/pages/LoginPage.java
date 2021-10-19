package qa.com.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.base.TestBase;
import qa.com.generic.ConfigReader;


public class LoginPage extends TestBase{
	
	private ConfigReader configReader;
	Properties prop;
	
	 //1. By locators 
	
	@FindBy(name="txtUsername")
	@CacheLookup
	WebElement userId;
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement userPassword;
	@FindBy(name="Submit")
	@CacheLookup
	WebElement btnLogin;
	@FindBy(xpath="//div[@id='forgotPasswordLink']//a")
	@CacheLookup
	WebElement inkForgetPwd;
	
	//2. Constructor of the page class:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//3. Page actions: feature(behavior) of the page from of the method:
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to get Login Page Title
     */
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to verify Forgot Password Link Displayed
     */
	public String verifyForgotPassworddLinkDisplayed(){
		return inkForgetPwd.getText();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to set User Name
     */
	 public void setUserName(String userName){
		 userId.sendKeys(userName);
	 }
	 
	 /**
	     * @author Jitendra.Sharma
	     *  @since 01 July 2021
	     * @description This Method used to set Password
	     */
	 public void setPassword(String password){
		 userPassword.sendKeys(password);
	 }
	 
	 /**
	     * @author Jitendra.Sharma
	     *  @since 01 July 2021
	     * @description This Method used to click On Login Button
	     */
	 public void clickOnLoginButton(){
		 btnLogin.click();
	 }
	 
	 public void doLogin(String un,String pwd){
		 this.setUserName(un);
		 this.setPassword(pwd);
		 this.clickOnLoginButton();
	 }
	 
	 public HomePage login() {
			configReader = new ConfigReader();
			prop = configReader.init_prop();
			String uName = prop.getProperty("userName");
			String uPassword = prop.getProperty("password");
			userId.sendKeys(uName);
			userPassword.sendKeys(uPassword);
			 btnLogin.click();
			return new HomePage();
		}
}
