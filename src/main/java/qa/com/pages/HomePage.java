package qa.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.base.TestBase;
import qa.com.generic.WrapperFunctions;


public class HomePage extends TestBase{
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	
	//By lblHomePage = By.xpath("//div[@id='branding']//img[@alt='OrangeHRM']");
	@FindBy(xpath="//div[@id='branding']//img[@alt='OrangeHRM']")
	WebElement lblHomePage;


	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	 /**
     * @author Jitendra.Sharma
     *  @since 14 Oct 2021
     * @description This Method used to click On Menu
     */
	public void clickOnMenu(String menu, String subMenu, String subMenuItem)
	{
		WebElement menu1 = driver.findElement(By.linkText(menu));
		Actions action=new Actions(driver);
		action.moveToElement(menu1).build().perform();
		menu1.click();
		if(subMenu != null){
			WebElement subMenu1 = driver.findElement(By.linkText(subMenu));
			action.moveToElement(subMenu1).build().perform();
			subMenu1.click();
		}
		if(subMenu != null && subMenuItem !=null){
			WebElement subMenuItems = driver.findElement(By.linkText(subMenuItem));
			subMenuItems.click();
		}
	}
	
	public boolean homeScreenDisplayed() throws InterruptedException{
		objWrapperFunctions.waitFor(2);
		return lblHomePage.isDisplayed();
	 }
}
