package com.ryg.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String format(Date theDate,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		return simpleDateFormat.format(theDate);
	}
	
	
	public static Date parse(String theDateStr,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			return simpleDateFormat.parse(theDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int getAge(Date theDate) {
		/** ��ȡ��ǰ���ڵ������� **/
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		/** ��ȡ���յ������� **/
		calendar.setTime(theDate);
		int theYear = calendar.get(Calendar.YEAR);
		int theMonth = calendar.get(Calendar.MONTH);
		int theDay = calendar.get(Calendar.DAY_OF_MONTH);
		/** ���� **/
		int age = year-theYear;
		/** �ж��·� **/
		if(month<theMonth) {
			age--;
		}
		/** �ж����� **/
		if(month==theMonth && day<theDay) {
			age--;
		}
		return age;
	}
	
	
	public static int getAge(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return getAge(theDate);
	}
	
	
	public static int getDayNum(Date date1,Date date2) {
		int dayTime = 1000*60*60*24;
		Long time1 = date1.getTime();
		Long time2 = date2.getTime();
		Long abs = Math.abs(time1-time2);
		Double dayNumDouble = abs/dayTime*1.0;
		return dayNumDouble.intValue();
	}
	
	
	public static int getDayNum(String date1Str,String date2Str) {
		Date date1 = parse(date1Str, "yyyy-MM-dd");
		Date date2 = parse(date2Str, "yyyy-MM-dd");
		return getDayNum(date1,date2);
	}
	
	
	public static int getDayNum(String date1Str) {
		Date date1 = new Date();
		Date date2 = parse(date1Str, "yyyy-MM-dd");
		return getDayNum(date1,date2);
	}
	
	public static int compare(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
	}
	
	public static boolean inWeek(Date theDate) {
		Calendar calendar = Calendar.getInstance();
		int theDay = calendar.get(Calendar.DAY_OF_WEEK);
		/** ��ǰ�ܵ���һ�� **/
		calendar.set(Calendar.DAY_OF_WEEK, 1-theDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startDate = calendar.getTime();
		/** ��ǰ�ܵ����һ�� **/
		calendar.add(Calendar.DAY_OF_WEEK, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endDate = calendar.getTime();
		return compare(theDate,startDate)==1 && compare(endDate, theDate)==1;
	}
	
	public static boolean inWeek(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return inWeek(theDate);
	}
	
	
	public static boolean inMonth(Date theDate) {
		Date nowDate = new Date();
		String nowYyyymm = format(nowDate, "yyyy-MM");
		String theYyyymm = format(theDate, "yyyy-MM");
		return nowYyyymm.equals(theYyyymm);
	}
	
	public static boolean inMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return inMonth(theDate);
	}
	
	public static Date getFirstDayOfMonth(Date theDate) {
		String theDateStr = format(theDate, "yyyy-MM-01");
		return parse(theDateStr, "yyyy-MM-dd");
	}
	
	public static Date getFirstDayOfMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return getFirstDayOfMonth(theDate);
	}
	
	
	public static Date getLastDayOfMonth(Date theDate) {
		/** ȡ���µĵ�һ�� **/
		Date firstDayOfMonth = getFirstDayOfMonth(theDate);
		/** ʵ���������ؼ� **/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstDayOfMonth);
		/** ����1�� **/
		calendar.add(Calendar.MONTH, 1);
		/** ��1�룬���µ�������� **/
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}
	
	
	public static Date getLastDayOfMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd HH:mm:ss");
		return getLastDayOfMonth(theDate);
	}
	
		
	public static void main(String[] args) {
			
			System.out.println(format(getLastDayOfMonth("2020-02-06 12:33:33"), "yyyy-MM-dd HH:mm:ss"));
		}
}
