package qa.com.generic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import qa.com.base.TestBase;

public class WrapperFunctions extends TestBase{
	
	/**
     * @author Jitendra.Sharma
     *  @since 14 Oct 2021
     * @description This Method used to Waits for the specified amount of [timeInMilliseconds]
     * @param  timeUnitSeconds - wait time seconds
     */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to generate Random int Number
     * @param  number
     */
	public int generateRandomNumber(int number){
		Random random = new Random();
		int x = random.nextInt(number);   
		return x;
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 01 July 2021
     * @description This Method used to generate Random String
     */
	public static String randomestring(){
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return (generateString1);
	}
	
	/**
     * @author Jitendra.Sharma
     *  @since 1st Jan 2022
     * @description This method used to select date from date picker table
     */
	public void selectDateFromDatePicker(String day, String month, String year){
		By drpmonth = By.xpath("//select[@class='ui-datepicker-month']");
		By drpYear = By.className("ui-datepicker-year");
		Select selectMonth = new Select(driver.findElement(drpmonth));
		this.waitFor(2);
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(driver.findElement(drpYear));
		this.waitFor(2);
		selectYear.selectByVisibleText(year);
		this.waitFor(2);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td//a[text()='"+day+"']")).click();
		
	}

}
