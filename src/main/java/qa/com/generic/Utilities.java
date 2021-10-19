package qa.com.generic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utilities {
	
	/**
     * @author Jitendra.Sharma
     * @since 15 Oct 2021
     * @description This Method is used to get required Date
     * @param incrementDays, expectedDateFormat, timeZoneId
     * @return this method will return date
     */
	public String getRequiredDate(String incrementDays, String expectedDateFormat, String timeZoneId) {
		try {
			DateFormat dateFormat;
			Calendar calendar = Calendar.getInstance();
			dateFormat = new SimpleDateFormat(expectedDateFormat);
			if (timeZoneId != null && !timeZoneId.equals(""))
				dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
			if (incrementDays != null && !incrementDays.equals(""))
				calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(incrementDays));
			Date date = calendar.getTime();
			String formattedDate = dateFormat.format(date);
			return formattedDate;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
     * @author Jitendra.Sharma
     * @since 15 Oct 2021
     * @description This Method is used to get required time
     * @param incrementMin, expectedDateFormat, timeZoneId
     * @return this method will return time
     */
	public String getRequiredTime(String incrementMin, String expectedDateFormat, String timeZoneId) {
		try {
			DateFormat dateFormat;
			Calendar calendar = Calendar.getInstance();
			dateFormat = new SimpleDateFormat(expectedDateFormat);
			if (timeZoneId != null && !timeZoneId.equals(""))
				dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
			if (incrementMin != null && !incrementMin.equals(""))
				calendar.add(Calendar.MINUTE, Integer.parseInt(incrementMin));
			Date time = calendar.getTime();
			String formattedTime = dateFormat.format(time);
			return formattedTime;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	/**
     * @author Jitendra.Sharma
     * @since 15 Oct 2021
     * @description This Method is used to get future or back date in the specific format
     * @param dateFormat, NoOfFutureDay
     * @return this method will return specific future date or back date
     */
	public String getFutureOrBackDateInSpecifiedFormat(String dateFormat, int NoOfFutureDay) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, NoOfFutureDay);
		String futureDate = new SimpleDateFormat(dateFormat).format(c.getTime()).toString();
		return futureDate;
	}

}
