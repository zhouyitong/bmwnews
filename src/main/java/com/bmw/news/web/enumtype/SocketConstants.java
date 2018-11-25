package com.bmw.news.web.enumtype;

import com.bmw.news.common.utils.Binary;

public class SocketConstants {

	public static String result(String phone_num1,String phone_num2,String phone_num3,String phone_num4,String phone_num5,
		String phone_num1_tel,String phone_num2_tel,String phone_num3_tel,String phone_num4_tel,String phone_num5_tel,
		String phone_num1_msg,String phone_num2_msg,String phone_num3_msg,String phone_num4_msg,String phone_num5_msg
			){
		String ad="ad";
 		String tzz="99";
 		String tz1="20";
 		String xlh="01";
 		String zjbm="04";
 		String yl="000000";
 		String[] nn={ad,tzz,tz1,xlh,zjbm};
 		String jyh=Binary.checkNum(nn);
 		String yl2="000000";
 		String csdmx="80";
 		String csxzjs="0064";
 		String phone1=Binary.zero(Binary.strTo16(phone_num1));
 		String phone2=Binary.zero(Binary.strTo16(phone_num2));
 		String phone3=Binary.zero(Binary.strTo16(phone_num3));
 		String phone4=Binary.zero(Binary.strTo16(phone_num4));
 		String phone5=Binary.zero(Binary.strTo16(phone_num5));
 		String source1=Binary.fistZero(Integer.parseInt(Binary.toHexString(phone_num1_tel+phone_num1_msg)));
 		String source2=Binary.fistZero(Integer.parseInt(Binary.toHexString(phone_num2_tel+phone_num2_msg)));
 		String source3=Binary.fistZero(Integer.parseInt(Binary.toHexString(phone_num3_tel+phone_num3_msg)));
 		String source4=Binary.fistZero(Integer.parseInt(Binary.toHexString(phone_num4_tel+phone_num4_msg)));
 		String source5=Binary.fistZero(Integer.parseInt(Binary.toHexString(phone_num5_tel+phone_num5_msg)));
 		String csxnr=source1+phone1+source2+phone2+source3+phone3+source4+phone4+source5+phone5;
 		String end="0d0a";
 		String result=ad+tzz+tz1+xlh+zjbm+yl+jyh+yl2+csdmx+csxzjs+csxnr+end;
		return result;
	}
	/**
	 * 操作无线传感器（添加学习、删除、编辑无线传感器）
	 * @return
	 */
	public static String operation(String operateModel,String sectorName,String sectorModel,String sectorCode ){
		String ad="AD";
 		String tzz="99";
 		String tz1="20";
 		String xlh="01";
 		String zjbm="04";
 		String yl="000000";
 		String[] nn={ad,tzz,tz1,xlh,zjbm};
 		String jyh=Binary.checkNum(nn);
 		String yl2="000000";
 		String csdmx="81";
 		String csxzjs="0004";
 		String end="0D0A";
 		String result=ad+tzz+tz1+xlh+zjbm+yl+jyh+yl2+csdmx+csxzjs+operateModel+sectorName+sectorModel+sectorCode+end;
		return result;
	}
	
	/**
	 * 无人活动持续时间设置
	 * @return
	 */
	public static String nobodyActivityTime(String morningNoTime,String morningTime,String nooningNoTime,String nooningTime,String afternoonNoTime,String afternoonTime,String eveningNoTime,String eveningTime ){
		String ad="ad";
 		String tzz="99";
 		String tz1="20";
 		String xlh="01";
 		String zjbm="04";
 		String yl="000000";
 		String[] nn={ad,tzz,tz1,xlh,zjbm};
 		String jyh=Binary.checkNum(nn);
 		String yl2="000000";
 		String csdmx="90";
 		String csxzjs="0010";
 		String end="0d0a";
 		String result=ad+tzz+tz1+xlh+zjbm+yl+jyh+yl2+csdmx+csxzjs+Binary.toHexTenString(morningNoTime)+Binary.toHexTimeString(morningTime)+Binary.toHexTenString(nooningNoTime)+Binary.toHexTimeString(nooningTime)+Binary.toHexTenString(afternoonNoTime)+Binary.toHexTimeString(afternoonTime)+Binary.toHexTenString(eveningNoTime)+Binary.toHexTimeString(eveningTime)+end;
 		//String result=ad+tzz+tz1+xlh+zjbm+yl+jyh+yl2+csdmx+csxzjs+operateModel+sectorName+sectorModel+sectorCode+end;
		return result;
	}
}
