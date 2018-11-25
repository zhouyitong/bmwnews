/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xywy.zngj.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	/**
	 * 获取整型时间戳（秒）
	 * @return
	 */
	public static Integer getIntTime() {
        return  (int)System.currentTimeMillis()/1000;
    }



	/**
	 * 获取当年的第一天
	 * @return
	 */
	public static Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	/**
	 * 获取当年的最后一天
	 * @return
	 */
	public static Date getCurrYearLast(){
		Calendar currCal=Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearLast(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	/**
	 * 当前时间所在一周的周一和周日时间
	 *
	 * @return
	 */
	public static Map<String, String> getWeekDate() {
		Map<String, String> map = Maps.newHashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (dayWeek == 1) {
			dayWeek = 8;
		}

		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		Date mondayDate = cal.getTime();
		String weekBegin = sdf.format(mondayDate);
		cal.add(Calendar.DATE, 4 + cal.getFirstDayOfWeek());
		Date sundayDate = cal.getTime();
		String weekEnd = sdf.format(sundayDate);

		map.put("mondayDate", weekBegin);
		map.put("sundayDate", weekEnd);
		return map;
	}

	/**
	 * 当前时间所在一个月的第一天和最后一天时间
	 *
	 * @return
	 */
	public static Map<String, String> getMonthDate() {
		Map<String, String> map = Maps.newHashMap();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		//获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());

		//获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());

		map.put("begin", first);
		map.put("end", last);
		return map;
	}

	// 获得某天最大时间 2017-10-15 23:59:59
	public static Date getEndOfDay(Date date) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
		LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
	}

	// 获得某天最小时间 2017-10-15 00:00:00
	public static Date getBeginOfDay(Date date) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
		LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
		return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
	}

	//得到时间戳
	public static Integer getIntegerTime(Date date){
		return new Long(date.getTime() / 1000).intValue();
	}

	//根据时间戳得到时间
	public static String getDateByInteger(Integer time){
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time*1000L);
	}

	/**
	 * 获取昨天的日期
	 * @return Date
	 */
	public static Date getYesterday(){
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		cal.set(Calendar.DATE, day - 1);
		String formatDate = DateUtils.formatDate(cal.getTime(), "yyyy-MM-dd");

		return DateUtils.parseDate(formatDate);
	}

	/**
	 * 获取某天的昨天
	 * @return Date
	 */
	public static Date getSomeYesterday(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DATE);
		cal.set(Calendar.DATE, day - 1);
		String formatDate = DateUtils.formatDate(cal.getTime(), "yyyy-MM-dd");

		return DateUtils.parseDate(formatDate);
	}

	/**
	 * 获取本周的第一天
	 * @return int
	 */
	public static String getWeekString(){
		Map<String, String> weekDate = DateUtils.getWeekDate();
		return weekDate.get("mondayDate");
	}
	/**
	 * 获取本月的第一天
	 * @return int
	 */
	public static Map<String, Object> getMonthInt(){
		Map<String, String> monthDate = DateUtils.getMonthDate();
		String begin = monthDate.get("begin");
		Calendar cal = Calendar.getInstance();
		int maxDate = cal.getActualMaximum(Calendar.DATE);
		Map<String, Object> map = Maps.newHashMap();
		map.put("day",begin);
		map.put("maxDate",maxDate);
		return map;
	}

	/**
	 * 根据type类型获取时间戳
	 * type 为0查本年 为1查本月 为2查本周
	 * @return Map
	 */
	public static Map<String,Integer> getBeginEndTime(String beginDate,String endDate,String date,Date beginOfDay
			,Date endOfDay,String type){
		Map<String,Integer> map = Maps.newHashMap();
		Integer beginTime = 0;
		Integer endTime = 0;
		if(StringUtils.isNoneEmpty(beginDate)){
			if(StringUtils.isEmpty(endDate)){
				endDate = date;
			}
			beginOfDay = DateUtils.getBeginOfDay(DateUtils.parseDate(beginDate));
			endOfDay = DateUtils.getEndOfDay(DateUtils.parseDate(endDate));
			beginTime = new Long(beginOfDay.getTime() / 1000).intValue();
			endTime = new Long(endOfDay.getTime() / 1000).intValue();
		}else {
			//type 为0查本年 为1查本月 为2查本周
			if (StringUtils.isNoneEmpty(type)) {
				if (type.equals("0")) {
					Date first = DateUtils.getCurrYearFirst();
					Date last = DateUtils.getCurrYearLast();
					beginOfDay = DateUtils.getBeginOfDay(first);
					endOfDay = DateUtils.getEndOfDay(last);
					beginTime = new Long(beginOfDay.getTime() / 1000).intValue();
					endTime = new Long(endOfDay.getTime() / 1000).intValue();

				} else if (type.equals("1")) {
					Map<String, String> monthDate = DateUtils.getMonthDate();
					String begin = monthDate.get("begin");
					String end = monthDate.get("end");
					beginOfDay = DateUtils.getBeginOfDay(DateUtils.parseDate(begin));
					endOfDay = DateUtils.getEndOfDay(DateUtils.parseDate(end));
					beginTime = new Long(beginOfDay.getTime() / 1000).intValue();
					endTime = new Long(endOfDay.getTime() / 1000).intValue();
				} else if (type.equals("2")) {
					Map<String, String> weekDate = DateUtils.getWeekDate();
					String mondayDate = weekDate.get("mondayDate");
					String sundayDate = weekDate.get("sundayDate");
					beginOfDay = DateUtils.getBeginOfDay(DateUtils.parseDate(mondayDate));
					endOfDay = DateUtils.getEndOfDay(DateUtils.parseDate(sundayDate));
					beginTime = new Long(beginOfDay.getTime() / 1000).intValue();
					endTime = new Long(endOfDay.getTime() / 1000).intValue();
				}
			} else {
				Date first = DateUtils.getCurrYearFirst();
				Date last = DateUtils.getCurrYearLast();
				beginOfDay = DateUtils.getBeginOfDay(first);
				endOfDay = DateUtils.getEndOfDay(last);
				beginTime = new Long(beginOfDay.getTime() / 1000).intValue();
				endTime = new Long(endOfDay.getTime() / 1000).intValue();
			}
		}

		map.put("beginTime",beginTime);
		map.put("endTime",endTime);
		return map;
	}


	/**
	 * 日期转int
	 * @return int
	 */
	public static int getDateInt(String date){
		date = date.replaceAll("-", "");
		return Integer.parseInt(date);
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
	}
}
