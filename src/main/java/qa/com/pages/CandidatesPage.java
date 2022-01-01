package qa.com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import qa.com.base.TestBase;
import qa.com.generic.WrapperFunctions;

public class CandidatesPage extends TestBase{
	
	private WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	
	/*@FindBy(xpath="//input[@id='btnAdd']")
	WebElement btnAdd;
	
	public CandidatesPage(){
		PageFactory.initElements(driver, this);
	}*/
	
	By btnAdd= By.id("btnAdd");
	By txtFistName = By.id("addCandidate_firstName");
	By txtLastName = By.id("addCandidate_lastName");
	By txtEmail = By.id("addCandidate_email");
	By txtContactNo = By.id("addCandidate_contactNo");
	By drpDownJobVacancy = By.id("addCandidate_vacancy");
	By txtResume = By.id("addCandidate_resume");
	By txtKeyword = By.id("addCandidate_keyWords");
	By txtComment = By.id("addCandidate_comment");
	By txtDate = By.id("addCandidate_appliedDate");
	By chkConsent = By.id("addCandidate_consentToKeepData");
	By btnSave = By.id("btnSave");
	
	public CandidatesPage(){
		super();
	}
	
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to click On Add button
     */
	public void clickOnaddBtn(){
		objWrapperFunctions.waitFor(2);
		driver.findElement(btnAdd).click();
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to set First Name
     */
	public void setFirstName(String firstName){
		driver.findElement(txtFistName).sendKeys(firstName);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to set last Name
     */
	public void setLastName(String lastName){
		driver.findElement(txtLastName).sendKeys(lastName);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to set Email Id
     */
	public void setEmailId(String email){
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to set Contact No
     */
	public void setContactNo(String contactNo){
		driver.findElement(txtContactNo).sendKeys(contactNo);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to select Job Vacancy
     */
	public void selectJobVacancy(String job){
		Select objSelect= new Select(driver.findElement(drpDownJobVacancy));
		objWrapperFunctions.waitFor(2);
		objSelect.selectByVisibleText(job);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to upload Resume
     */
	public void uploadResume(String resumePath){
		driver.findElement(txtResume).sendKeys(resumePath);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to set Keyword
     */
	public void setKeyword(String keyword){
		driver.findElement(txtKeyword).sendKeys(keyword);
	}
	

	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to set Comment
     */
	public void setComment(String comment){
		driver.findElement(txtComment).sendKeys(comment);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to select Date 
     */
	public void selectDate(String day, String month ,String year){
		driver.findElement(txtDate).click();
		objWrapperFunctions.selectDateFromDatePicker(day, month, year);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to click On Consent Check Box
     */
	public void clickOnConsentCheckBox(){
		WebElement consentCheckBox = driver.findElement(chkConsent);
		if(!consentCheckBox.isSelected()){
			consentCheckBox.click();
		}
	}


	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to click On Save Btn
     */
	public void clickOnSaveBtn(){
		driver.findElement(btnSave).click();
	}
}
