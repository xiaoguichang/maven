package com._21cn.fbmp.common.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com._21cn.framework.util.StringUtil;

/**
 * 
 * 各种日期操作
 * 
 * @Package: com.ctid.util
 * @ClassName: DateUtil
 * @author xudongdong
 * @date 2009-3-26 下午01:36:29
 * @Copyright © SI-TECH 2012. All rights reserved
 * @version: V1.0
 * 
 * 修改日期 修改人 修改目的
 */
public class DateUtil {
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private static Logger logger = Logger.getLogger(DateUtil.class);

	/**
	 * 
	 * 日期的算术操作，可以增加或者减少，可以某一部分进行操作 year--年 month-月 1-12 day-天 1-31 hour -小时 0-23
	 * minute 分钟 0-59 second 秒 0-59 millisecond 毫秒 显示格式，可以任意组合
	 * 
	 * G Era designator Text AD y Year Year 1996; 96 M Month in year Month July;
	 * Jul; 07 w Week in year Number 27 W Week in month Number 2 D Day in year
	 * Number 189 d Day in month Number 10 F Day of week in month Number 2 E Day
	 * in week Text Tuesday; Tue a Am/pm marker Text PM H Hour in day (0-23)
	 * Number 0 k Hour in day (1-24) Number 24 K Hour in am/pm (0-11) Number 0 h
	 * Hour in am/pm (1-12) Number 12 m Minute in hour Number 30 s Second in
	 * minute Number 55 S Millisecond Number 978 z Time zone General time zone
	 * Pacific Standard Time; PST; GMT-08:00 Z Time zone RFC 822 time zone -0800
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param srcDate
	 * @param srcFormat
	 * @param destFormat
	 * @param operType
	 * @param operValue
	 * @return
	 */
	public static String evalTime(String srcDate, String srcFormat,
			String destFormat, String operType, int operValue) {
		if (srcDate == null || srcDate.equals(""))
			return "";
		if (srcFormat == null || srcFormat.equals(""))
			srcFormat = "yyyy-MM-dd";
		if (destFormat == null || destFormat.equals(""))
			destFormat = "yyyy-MM-dd";
		if (operType == null || operType.equals(""))
			operType = "day";

		// Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("AST"));
		Calendar cal = Calendar.getInstance();
		Date currentTime = null;
		try {
			currentTime = (Date) new java.text.SimpleDateFormat(srcFormat)
					.parse(srcDate);
		} catch (ParseException e) {
			logger.error("", e);
			currentTime = new Date();
		}
		cal.setTime(currentTime);
		if (operType.equals("year")) {
			cal.add(Calendar.YEAR, operValue);
		} else if (operType.equals("month")) {
			cal.add(Calendar.MONTH, operValue);
		} else if (operType.equals("day")) {
			cal.add(Calendar.DAY_OF_MONTH, operValue);
		} else if (operType.equals("hour")) {
			cal.add(Calendar.HOUR_OF_DAY, operValue);
		} else if (operType.equals("minute")) {
			cal.add(Calendar.MINUTE, operValue);
		} else if (operType.equals("second")) {
			cal.add(Calendar.SECOND, operValue);
		} else if (operType.equals("millisecond")) {
			cal.add(Calendar.MILLISECOND, operValue);
		}
		String curDay = new java.text.SimpleDateFormat(destFormat).format(cal
				.getTime());
		return curDay;
	}

	/**
	 * 
	 * 获得当前时间 转换为时间戳类型
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp getCurTime2Timestamp() throws ParseException {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		String d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(t);
		Timestamp.valueOf(d2);
		return t;
	}

	/**
	 * 
	 * 日期格式转化
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param srcDate
	 *            源日期字符串
	 * @param srcFormat
	 *            源日期格式，默认为yyyy-MM-dd
	 * @param destFormat
	 *            目的日期格式，默认为yyyy-MM-dd
	 * @return 转换格式后的日期字符串 或 空字符串
	 */
	public static String dateFormat(String srcDate, String srcFormat,
			String destFormat) {
		if (srcFormat == null || srcFormat.equals(""))
			srcFormat = "yyyy-MM-dd";
		if (destFormat == null || destFormat.equals(""))
			destFormat = "yyyy-MM-dd";
		if (srcDate == null || srcDate.equals(""))
			return "";

		Calendar cal = Calendar.getInstance();
		Date currentTime = null;
		try {
			currentTime = (Date) new java.text.SimpleDateFormat(srcFormat)
					.parse(srcDate);
		} catch (ParseException e) {
			logger.error("", e);
			currentTime = new Date();
		}

		cal.setTime(currentTime);
		String curDay = new java.text.SimpleDateFormat(destFormat).format(cal
				.getTime());

		return curDay;
	}

	/**
	 * 
	 * 日期格式转化
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param srcDate
	 *            源日期字符串
	 * @param destFormat
	 *            目的日期格式，默认为yyyy-MM-dd
	 * @return 转换格式后的日期字符串 或 空字符串
	 */
	public static String dateFormat(Date srcDate, String destFormat) {
		if (srcDate == null)
			return "";
		if (destFormat == null || destFormat.equals(""))
			destFormat = "yyyy-MM-dd";
		String curDay = new java.text.SimpleDateFormat(destFormat)
				.format(srcDate);
		return curDay;
	}

	/**
	 * 
	 * 字符串日期转化为java.util.Date
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param srcDate
	 *            源日期字符串
	 * @param srcFormat
	 *            源日期格式，默认为yyyy-MM-dd
	 * @return 转换后的Date对象， 如果srcDate为空或异常，则返回当前日期
	 */
	public static Date StringToDate(String srcDate, String srcFormat) {
		if (srcDate == null || srcDate.equals(""))
			return new Date();

		if (srcFormat == null || srcFormat.equals(""))
			srcFormat = "yyyy-MM-dd";

		Calendar cal = Calendar.getInstance();
		Date currentTime = null;

		try {
			currentTime = (Date) new java.text.SimpleDateFormat(srcFormat)
					.parse(srcDate);
		} catch (ParseException e) {
			logger.error("", e);
			currentTime = new Date();
		}

		cal.setTime(currentTime);

		return cal.getTime();
	}

	/**
	 * 
	 * 将字符串格式化为‘yyyy-MM-dd HH:mm:ss’格式的java.util.Date
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param srcDate
	 *            源日期字符串
	 * @return 转换后的Date对象
	 */
	public static Date StringToDate(String srcDate) {
		if("".equals(srcDate) || srcDate == null) return null;
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		try {
			d = sdf.parse(srcDate);
		} catch (ParseException e) {
			logger.error("", e);
		}

		return d;
	}

	/**
	 * 
	 * 比较两个日期的大小
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param d1
	 * @param d2
	 * @return 如果d1大于d2，返回true，否则返回false
	 */
	public static boolean compare(Date d1, Date d2) {
		if (d1.after(d2)) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * 获取当前时间
	 * @param format
	 * @return
	 */
	public static String genDateStr(String format) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * 
	 * 将指定的日期转换成字符串
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param aDteValue
	 *            要转换的日期
	 * @param aFmtDate
	 *            转换后日期的格式，默认为yyyy-MM-dd
	 * @return 转换之后的字符串，如果异常，则返回null
	 */
	public static String dateToStr(java.util.Date aDteValue, String aFmtDate) {
		String strRtn = null;

		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyy/MM/dd";
		}
		Format fmtDate = new SimpleDateFormat(aFmtDate);
		try {
			strRtn = fmtDate.format(aDteValue);
		} catch (Exception e) {
			logger.error("", e);
		}

		return strRtn;
	}

	/**
	 * 名称：strToDate 功能：将指定的字符串转换成日期 输入：aStrValue: 要转换的字符串; aFmtDate: 转换日期的格式,
	 * 默认为:"yyyy/MM/dd" aDteRtn: 转换后的日期 输出： 返回：TRUE: 是正确的日期格式; FALSE: 是错误的日期格式
	 */
	/**
	 * 
	 * 将指定的字符串转换成日期
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param aStrValue
	 *            要转换的字符串
	 * @param aFmtDate
	 *            转换日期的格式，默认为yyyy-MM-dd
	 * @param aDteRtn
	 *            转换之后的字符串
	 * @return true-是正确的日期格式; false-是错误的日期格式
	 */
	public static boolean strToDate(String aStrValue, String aFmtDate,
			java.util.Date aDteRtn) {
		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyy/MM/dd";
		}

		SimpleDateFormat fmtDate = new SimpleDateFormat(aFmtDate);

		try {
			aDteRtn.setTime(fmtDate.parse(aStrValue).getTime());
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}

		return true;
	}

	/**
	 * 
	 * 将指定时间转为字符串格式（字符串格式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date
	 *            被转换的时间对象
	 * @return 转换后的字符串
	 */
	public static String date2String(Date date) {
		if(date == null) return "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	/**
	 * 
	 * 将指定时间转为指定字符串格式
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date
	 *            被转换的时间对象
	 * @param format
	 *            转换后格式串
	 * @return 转换后的字符串
	 */
	public static String date2Str(Date date, String format) {
		if(date == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 
	 * 将当前时间转为字符串格式（字符串格式：yyyy-MM-dd HH:mm:ss）
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @return
	 */
	public static String currentTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date());
	}

	/**
	 * 
	 * java.util.Date转化为java.sql.Date
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date
	 *            被转换的日期对象
	 * @return 转换后的日期对象, 若入参为null，则返回null
	 */
	public static java.sql.Date parseSqlDate(java.util.Date date) {
		if (date == null)
			return null;
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 
	 * java.util.Date转化为java.sql.Timestamp
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date
	 *            被转换的日期对象
	 * @return 转换后的时间戳对象, 若入参为null，则返回null
	 */
	public static java.sql.Timestamp parseTimestamp(Date date) {
		if (date == null)
			return null;

		long t = date.getTime();

		return new java.sql.Timestamp(t);
	}

	/**
	 * 
	 * 日期相减(date-date1)
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date
	 * @param date1
	 * @return 返回相减后的日期毫秒数，若入参为null，则返回0
	 */
	public static long diffDate(java.util.Date date, java.util.Date date1) {
		if (date == null)
			return 0;
		if (date1 == null)
			return 0;

		return date.getTime() - date1.getTime();
	}

	/**
	 * 
	 * 针对年月取出最大的天数
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param yearmonth
	 * @return
	 * 
	 * modify by shibc 20090402
	 */
	public static String getMaxDay(String yearmonth) {

		/*
		 * String day=""; int year=0; int month=0;
		 * 
		 * month=Integer.parseInt(yearmonth.substring(4));
		 * year=Integer.parseInt(yearmonth.substring(0, 4));
		 * 
		 * boolean isLeap=isLeapyear(year); if(isLeap==true){
		 * 
		 * switch(month){ case 1: case 3: case 5: case 7:case 8:case 10:case
		 * 12:day="31"; break; case 2:day="29"; break; case 4:case 6:case 9:case
		 * 11:day="30"; } }else{ switch(month){ case 1: case 3: case 5: case
		 * 7:case 8:case 10:case 12:day="31"; break; case 2:day="28"; break;
		 * case 4:case 6:case 9:case 11:day="30"; } }
		 * 
		 * return day;
		 */
		String tmp = evalTime(yearmonth, "yyyyMM", "yyyyMM", "month", 1);
		String tmp2 = tmp + "01";
		String tmp3 = evalTime(tmp2, "yyyyMMdd", "dd", "day", -1);
		return tmp3;
	}

	/**
	 * 
	 * 针对下月月初日期
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @return
	 * 
	 * modify by jiangmm 20091204
	 */
	public static String getNextBeginDay() {
		Calendar cal = Calendar.getInstance();
		@SuppressWarnings("unused")
		String endDate_year = String.valueOf(cal.get(Calendar.YEAR));
		@SuppressWarnings("unused")
		String endDate_month = "";
		if (cal.get(Calendar.MONTH) + 1 < 10) {
			endDate_month = "0" + (cal.get(Calendar.MONTH) + 1);
		} else {
			endDate_month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		}
		@SuppressWarnings("unused")
		String endDate_day = String.valueOf(cal
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		String effDate_year = "";
		String effDate_month = "";
		// 当月为12月时，下月应该为下一年的1月，下个月的年份应该加1
		if (cal.get(Calendar.MONTH) + 1 == 12) {
			effDate_year = String.valueOf(cal.get(Calendar.YEAR) + 1);
			effDate_month = "01";
		} else {
			effDate_year = String.valueOf(cal.get(Calendar.YEAR));
			// 当下月为小于10月时，应该为下月的前面加0，如02到09
			if (cal.get(Calendar.MONTH) + 2 < 10) {
				effDate_month = "0" + (cal.get(Calendar.MONTH) + 2);
			} else {
				effDate_month = String.valueOf(cal.get(Calendar.MONTH) + 2);
			}
		}

		String effDate = effDate_year + effDate_month + "01";// 更改后套餐生效日期
		return effDate;
	}

	/**
	 * 
	 * 判断是否是闰年
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param year
	 * @return true-year是闰年，false-year不是闰年
	 */
	public boolean isLeapyear(int year) {

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 获得当前月份 转换为Long类型
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @return 当前月份值
	 * @throws ParseException
	 */
	public static Long getCurMonth2Long() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		// t_log_echn_servinvoke.setTime_range(Long.valueOf(sdf.format(date)));
		return Long.parseLong(sdf.format(date));
	}

	/**
	 * 
	 * 比较当前时间是否在这两个时间点之间
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param time1
	 *            起始时间串
	 * @param time2
	 *            终止时间串
	 * @return true-当前时间在tiem1与time2之间，false-当前时间不在tiem1与time2之间
	 */
	public static boolean checkTimeEarly(String time1, String time2) {
		Calendar calendar = Calendar.getInstance();
		Date date1 = calendar.getTime();
		Date date11 = DateUtil.StringToDate(DateUtil.dateToStr(date1,
				"yyyy-MM-dd")
				+ " " + time1, DEFAULT_PATTERN);// 起始时间
		Calendar c = Calendar.getInstance();
		/* c.add(Calendar.DATE, 1); */
		Date date2 = c.getTime();
		Date date22 = DateUtil.StringToDate(DateUtil.dateToStr(date2,
				"yyyy-MM-dd")
				+ " " + time2, DEFAULT_PATTERN);// 终止时间
		Calendar scalendar = Calendar.getInstance();
		scalendar.setTime(date11);// 起始时间
		Calendar ecalendar = Calendar.getInstance();
		ecalendar.setTime(date22);// 终止时间
		Calendar calendarnow = Calendar.getInstance();
		// modify by liuxw for 跨天问题
		if (calendarnow.after(scalendar) || calendarnow.before(ecalendar)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * 比较时间是否在这两个时间点之间 added by liuxw
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param time1
	 *            起始时间串 必须是yyyy-MM-dd HH:mm:ss格式
	 * @param time2
	 *            终止时间串 必须是yyyy-MM-dd HH:mm:ss格式
	 * @return true-当前时间在tiem1与time2之间，false-当前时间不在tiem1与time2之间
	 */
	public static boolean checkTimeBetween(String time1, String time2) {
		Date beginTime = DateUtil.StringToDate(time1);
		Date endTime = DateUtil.StringToDate(time2);
		Calendar scalendar = Calendar.getInstance();
		scalendar.setTime(beginTime);
		Calendar ecalendar = Calendar.getInstance();
		ecalendar.setTime(endTime);// 终止时间
		Calendar calendarnow = Calendar.getInstance();
		if (calendarnow.after(scalendar) && calendarnow.before(ecalendar)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 判断日期date1是否失效
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date1
	 *            失效时间
	 * @param date2
	 *            当前时间
	 * @param delay
	 *            失效阀值（天）
	 * @return ture-已失效， false-未失效
	 */
	public boolean toRemind(Date date1, Date date2, int delay) {

		Long time = DateUtil.diffDate(date1, date2);
		if (delay > time / (60 * 60 * 24 * 1000)) {
			return false;// 未失效
		} else {
			return true;// 即将失效，提醒
		}
	}

	/**
	 * 
	 * 获得上一个月的月份
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param cal
	 * @return 上月月份对象Calendar
	 */
	public static Calendar getPreviousMonth(Calendar cal) {
		// String str = "";
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");

		if (cal == null) {
			cal = Calendar.getInstance();
		}
		cal.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		return cal;
	}

	/**
	 * 
	 * 根据日期类型更改时间
	 * 
	 * @author xudongdong
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param date
	 *            源日期对象
	 * @param type
	 *            date, year, month
	 * @param value
	 *            增加值
	 * @return 更改后的日期对象
	 */
	public static Date changeDate(Date date, String type, int value) {
		// Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		// Calendar calendar = Calendar.
		if (type.equals("month")) {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + value);
		} else if (type.equals("date")) {
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + value);
		} else if (type.endsWith("year")) {
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + value);
		}
		return calendar.getTime();
	}

	/**
	 * 
	 * 月份相减
	 * 
	 * @author zhaoweia zhaoweia@si-tech.com.cn
	 * @date 2009-3-26 下午01:36:29
	 * @version: V1.0
	 * 
	 * @param startDate
	 *            开始时间
	 * @param enDate
	 *            结束时间
	 * @return 相差月数
	 */
	public static int divMonth(Date startDate, Date enDate) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(enDate);

		int yearDiv = startCalendar.get(Calendar.YEAR)
				- endCalendar.get(Calendar.YEAR);

		int monthDiv = startCalendar.get(Calendar.MONTH)
				- endCalendar.get(Calendar.MONTH);

		return monthDiv + yearDiv * 12;
	}

	/**
	 * 返回日期对应是星期几
	 * @param date
	 * @return
	 */
	public static String displayDayOfWeek(Date date) {
		String result = "";
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			result="星期日";
			break;
		case 2:
			result="星期一";
			break;
		case 3:
			result="星期二";
			break;
		case 4:
			result="星期三";
			break;
		case 5:
			result="星期四";
			break;
		case 6:
			result="星期五";
			break;
		case 7:
			result="星期六";
			break;
		}
		return result;
	}
	/**
	 * 获取指定时间前后N天的时间
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getDate(Date date,int day){
		if(day==0){
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}
	
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return year;
	}
	
	/***
	 * 获取指定日期前后N个月的日期
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getDateByMonth(Date date,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(month!=0){
			calendar.add(Calendar.MONTH, month);
		}
		return calendar.getTime();
	}
	
	
	/**
	 * 格式化当前时间为long类型数值
	 * @param date
	 * @return
	 */
	public static long formatDate2Long(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");

		long time = Long.parseLong(simpleDateFormat.format(new Date()));

		return time;
	}
	
	
	public static int getMinuteDiffByTime(Date time1, Date time2) {
        long startMil = 0;
        long endMil = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time1);
        calendar.set(1900, 1, 1);
        startMil = calendar.getTimeInMillis();
        calendar.setTime(time2);
        calendar.set(1900, 1, 1);
        endMil = calendar.getTimeInMillis();
        return (int) ((endMil - startMil) / 1000 / 60);
    }
	
	public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");   
        java.util.Date beginDate;
        java.util.Date endDate;
        try
        {
            beginDate = format.parse(beginDateStr);
            endDate= format.parse(endDateStr);   
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);   
        } catch (ParseException e)
        {
            e.printStackTrace();
        }  
        return day;
    }
	
	public static String getDateStr(String format) {
		
		if (StringUtil.isEmpty(format)) {
			format = "yyyyMMddHHmmssSSSS";
		}
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	public static int getDateRelation() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(year, month - 1, day, 0, 0, 0);
		Date dateStart = cal.getTime();
		Date dateCurrent = new Date();
		int dateStartInt = (new BigDecimal(dateStart.getTime() / 1000)
				.setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();
		int dateCurrentInt = (new BigDecimal(dateCurrent.getTime() / 1000)
				.setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();
		return dateCurrentInt - dateStartInt + 10000;
	}
}
