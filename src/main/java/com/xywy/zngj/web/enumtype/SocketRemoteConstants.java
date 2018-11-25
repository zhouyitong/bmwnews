package com.xywy.zngj.web.enumtype;

import com.xywy.zngj.common.utils.Binary;

public class SocketRemoteConstants {
	public static String remote(String mldm){
		String ad="ad";
		String tzz="99";
		String tz1="11";
		String xlh="00";
		String zjbm="06";
		String yl="000000";
		String[] nn={ad,tzz,tz1,xlh,zjbm};
 		String jyh=Binary.checkNum(nn);
		String yl2="000000";
		String mlcs1="00";
		String mlcs2="00";
		String end="0d0a";
		String result=ad+tzz+tz1+xlh+zjbm+yl+jyh+yl2+mldm+mlcs1+mlcs2+end;
		return result;
	}
}
