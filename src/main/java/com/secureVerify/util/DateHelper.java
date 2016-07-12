package com.secureVerify.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public final class DateHelper{

	public static String DATETIMEPICKER_DATE_STRING_FORMAT = "YYYY-MM-DD HH:MM:ss z";
	public static String SQL_DATE_STRING_FORMAT = "MM-dd-yyyy";
	public static String JS_DATE_STRING_FORMAT = "MM/dd/yyyy";
	public static String TIME_AM_PM_STRING_FORMAT = "HH:mm a";
	public static final int MILLI_TO_HOUR = 1000 * 60 * 60;
	public static final int MILLI_TO_DAY = 1000 * 60 * 60 * 24;
	
	private DateHelper(){
	}
	
	public static int getHoursDifference(Date date1, Date date2) {
	    int i = (int) (date2.getTime() - date1.getTime()) / MILLI_TO_HOUR;
	    if(((date1.getTime() - date2.getTime()) % MILLI_TO_HOUR) > 0){
	    	i++;
	    }
	    return i;
	}
	
	public static int getDaysDifference(Date date1, Date date2) {
	    return (int) (date2.getTime() - date1.getTime()) / MILLI_TO_DAY ;
	}
	
	public static final String getTimeFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_AM_PM_STRING_FORMAT);
		return sdf.format(date);
	}
	
	public static final String getDateInSpecifiedFormat(Date date, String newFormat) {
		String strDate = "";
		if (date == null || newFormat == null || newFormat.trim().length() == 0) {
			return strDate;
		}
		try {
			strDate = new SimpleDateFormat(newFormat.trim()).format(date);
		} catch (Exception exception) {
			strDate = "";
		}
		return strDate;
	}

	public static final Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		setDateHoursZero(calendar);
		return calendar.getTime();
	}

	public static final Date addTwoDaysToDate() {
		Calendar calendar = Calendar.getInstance();
		setDateHoursZero(calendar);
		calendar.add(Calendar.DATE, 3);
		return calendar.getTime();
	}

	public static final Date add30DaysToCurentDate() {
		Calendar calendar = Calendar.getInstance();
		setDateHoursZero(calendar);
		calendar.add(Calendar.DATE, 30);
		return calendar.getTime();
	}

	public static final Date getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		Calendar calendarTemp = Calendar.getInstance();
		calendarTemp.setTime(date);
		setDateHoursZero(calendar);
		setCalendar(calendarTemp, calendar);
		return calendar.getTime();
	}

	private static final void setDateHoursZero(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	private static final void setCalendar(Calendar source, Calendar target){
		target.set(Calendar.DATE, source.get(Calendar.DATE));
		target.set(Calendar.MONTH, source.get(Calendar.MONTH));
		target.set(Calendar.YEAR, source.get(Calendar.YEAR));
	}

	public static Date getUtilDate(java.sql.Date sDate) {
		Date uDate = new Date(sDate.getTime());
		return uDate;
	}

	public static boolean isEqual(Calendar c1, java.util.Date d1) {
		boolean flag = false;
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d1);
		int i = c1.compareTo(c2);
		if (i == 0) {
			flag = true;
		}
		return flag;
	}

	public static boolean isEqual(java.util.Date d1, java.util.Date d2) {
		boolean flag = false;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		int i = c1.compareTo(c2);
		if (i == 0) {
			flag = true;
		}
		return flag;
	}
	
	public static Date getUtilDateFromString(String date){
		Date uDate=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			uDate = dateFormat.parse(date);
		} catch (Exception e) { }
		return uDate;
	}
	

	public static Date getDateFromString(String date){
		Date uDate = null;
		if(date!=null && !date.trim().equals("")){
			uDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				uDate = dateFormat.parse(date);
			} catch (Exception e) { }
		}
		return uDate;
	}
	
	public static Date getUtilDateFromJSString(String date){
		Date uDate=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(JS_DATE_STRING_FORMAT);
		try {
			uDate = dateFormat.parse(date);
		} catch (Exception e) { }
		return uDate;
	}
	
	public static Date getUtilDateFromDatePickerString(String date){
		Date uDate=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		try {
			uDate = dateFormat.parse(date);
		} catch (Exception e) { }
		return uDate;
	}
	
	public static Date getUtilDateTimeFromString(String date){
		Date uDate=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			uDate = dateFormat.parse(date);
		} catch (Exception e) { }
		return uDate;
	}
	
	public static java.sql.Date getSQLDateFromString(String date){
		Date uDate=new Date();
		java.sql.Date sDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
		try {
			uDate = dateFormat.parse(date);
			sDate = getUtilDateToSqlDate(uDate);
		} catch (Exception e) { }
		return sDate;
	}

	public static String getTodaysDate(){
		return getDateInSpecifiedFormat(new java.util.Date(), SQL_DATE_STRING_FORMAT);
	}

	@SuppressWarnings("deprecation")
	public static String getSqlToUtilString(String sql){
		StringTokenizer st=new StringTokenizer(sql,"-");
		Date d=new Date();
		d.setDate(1);
		d.setYear(Integer.parseInt(st.nextToken())-1900);
		d.setMonth(Integer.parseInt(st.nextToken())+1);
		return  (d.getMonth())+"-01"+"-"+(d.getYear()+1900); 
	}

	public static java.sql.Date getUtilDateToSqlDate(Date date) {
		Calendar d = Calendar.getInstance();
		d.setTime(date);
		java.sql.Date d2= new java.sql.Date(d.getTimeInMillis());
		return d2;
	}
	
	public static Date getUtilDateFromSQLString(String date){
		Date uDate=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			uDate = dateFormat.parse(date);
		} catch (Exception e) { }
		return uDate;
	}
	
	public static boolean getRecordDateComparison(Date startDate, int recordNoOfDays){
		boolean flag = false;
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		Date date = new Date();
		c.add(Calendar.DATE, recordNoOfDays);  
		if(date.getTime() <= c.getTimeInMillis() ){
			flag =true;
		}
		return flag;
	}
	
	public static Date getCurrentUtilDate(){
		return new Date(System.currentTimeMillis());
	}
}
