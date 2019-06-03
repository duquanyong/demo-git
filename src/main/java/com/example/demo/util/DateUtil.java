package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.springframework.util.StringUtils;

/**
 * 日期工具类
 * @author Administrator
 *
 */
public class DateUtil {
	
public static String defaultDatePattern = "yyyy/MM/dd";
	
	public static String pattern2 = "yyyy-MM-dd";
	
	public static String pattern3 = "yyyy年MM月dd日";
	
	public static String pattern4 = "yyyy年MM月";
	
	public static String pattern5 = "yyyyMMdd";
	
	public static String pattern6 = "yy年MM月";
	
 
	public static String datePatternYMDHMS = "yyyy-MM-dd-HH:mm:ss";

	public static String pattern1 =  "EEE, d MMM yyyy HH:mm:ss Z";
	
	public static String patternMM = "MM";

	/**
	 * 日期对象转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	/**
	 * 字符串转日期对象
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date formatString(String str,String format) throws Exception{
		if(StringUtils.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	public static String getCurrentDateStr()throws Exception{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
	}
	
	
	
	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
 
	
	 public static void main(String[] args) {
	        Calendar cal = Calendar.getInstance();
	        int day = cal.get(Calendar.DATE);
	        int month = cal.get(Calendar.MONTH) + 1;
	        int year = cal.get(Calendar.YEAR);
	        int dow = cal.get(Calendar.DAY_OF_WEEK);
	        int dom = cal.get(Calendar.DAY_OF_MONTH);
	        int doy = cal.get(Calendar.DAY_OF_YEAR);
	 
	        
	        System.out.println("当期时间: " + cal.getTime());
	        System.out.println("日期: " + day);
	        System.out.println("月份: " + month);
	        System.out.println("年份: " + year);
	        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
	        System.out.println("一月中的第几天: " + dom);
	        System.out.println("一年的第几天: " + doy);
	        
	        System.out.println(formatDate(new Date(), "MM"));
	    }
		/**
		 * 添加天数，并重新设置小时和分钟
		 * @param date
		 * @param aDay
		 * @param h
		 * @param m
		 * @return
		 */
		public static Date addDay(Date date, int aDay) {
			Calendar currCal = Calendar.getInstance();
			currCal.setTime(new Date());
			
			Calendar updCal = Calendar.getInstance();
			updCal.setTime(date);
			
			updCal.add(Calendar.DATE , aDay);
			updCal.set(Calendar.HOUR_OF_DAY, currCal.get(Calendar.HOUR_OF_DAY));
			updCal.set(Calendar.MINUTE, currCal.get(Calendar.MINUTE));
			updCal.set(Calendar.SECOND, currCal.get(Calendar.SECOND));
			return updCal.getTime();
		}
		
		/**
		 * 使用参数Format格式化Date成字符串
		 */
		public static String format(Date date, String pattern) {
			return date == null ? " " : new SimpleDateFormat(pattern).format(date);
		}
		
		/**
		 * 使用参数Format格式化Date成字符串
		 */
		public static String format(Date date, String pattern, Locale local) {  
			return date == null ? " " : new SimpleDateFormat(pattern,local).format(date);
		}
		
		/**
		 * 使用参数Format将字符串转为Date
		 */
		public static Date parse(String strDate, String pattern) throws ParseException {
			return strDate.length() == 0 ? null : new SimpleDateFormat(pattern).parse(strDate);
		}
		
		/**
		 * 使用预设格式将字符串转为Date
		 */
		public static Date parse(String strDate) throws ParseException {
			return strDate.length() == 0 ? null : parse(strDate, "yyyy-MM-dd");
		}

		/**
		 * 使用预设Format格式化Date成字符串
		 */
		public static String format(Date date) {
			return date == null ? " " : format(date, "yyyy-MM-dd");
		}
}
