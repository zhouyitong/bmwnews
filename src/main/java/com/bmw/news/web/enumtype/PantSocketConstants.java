package com.bmw.news.web.enumtype;

import java.util.Calendar;

import com.bmw.news.common.utils.Binary;

public class PantSocketConstants {

	public static String affirm(String souce){
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
		String ad="ad";
		String tzz="99";
		String tz1="09";
		String xlh=souce;
		String yl="07";
		String yl1="00";
		String yl2="00";
		String yl3="00";
		String[] nn={ad,tzz,tz1,xlh,yl};
 		String jyh=Binary.checkNum(nn);
		String second=Binary.addZeroForNum(Integer.toHexString(cal.get(Calendar.SECOND)),2);//秒
		String minute=Binary.addZeroForNum(Integer.toHexString(cal.get(Calendar.MINUTE)),2);//分
		String hour=Binary.addZeroForNum(Integer.toHexString(cal.get(Calendar.HOUR)),2);//小时
		String day=Binary.addZeroForNum(Integer.toHexString(cal.get(Calendar.DATE)),2);//获取日
		String month=Binary.addZeroForNum(Integer.toHexString(cal.get(Calendar.MONTH)),2);//获取月份
		String yearFooter=String.valueOf(year).substring(2, 4);//年后俩位
		String yearFrist=String.valueOf(year).substring(0, 2);//年前俩位
		String yarLast=Binary.addZeroForNum(Integer.toHexString(Integer.valueOf(yearFooter)),2);
		String yearHeder=Binary.addZeroForNum(Integer.toHexString(Integer.valueOf(yearFrist)),2);
		String end="0d0a";
		String result=ad+tzz+tz1+xlh+yl+yl1+yl2+yl3+jyh+second+minute+hour+day+month+yarLast+yearHeder+end;
		return result;
	}
}
