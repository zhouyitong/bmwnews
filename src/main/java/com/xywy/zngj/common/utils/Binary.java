package com.xywy.zngj.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URL;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import org.apache.commons.collections.map.ListOrderedMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xywy.zngj.web.enumtype.ApiConstants;

public class Binary {
	private static String hexStr = "0123456789ABCDEF";

	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}

	public static String bytesToHexString(byte[] result) {
		StringBuffer sb = new StringBuffer(result.length * 2);
		for (int i = 0; i < result.length; i++) {
			sb.append(Character.forDigit((result[i] & 240) >> 4, 16));
			sb.append(Character.forDigit(result[i] & 15, 16));
		}
		return sb.toString();
	}

	public static String HexString16(String str) {
		String[] strs = str.split("\\s+");
		String result = "";
		for (String string : strs) {
			String hex = Integer.toString(Integer.parseInt(string, 2), 16);
			result += hex;
		}
		System.out.println(result);
		return result;
	}

	// 十六进制转二进制
	public static String HexToBinary(String s) {
		return Long.toBinaryString(Long.parseLong(s, 16));
	}

	public class Converter {
		// 二进制转十六进制
		String BinaryToHex(String s) {
			return Long.toHexString(Long.parseLong(s, 2));
		}

	}
	//十六进制转二进制
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789abcdef".indexOf(c);
		return b;
	}

	public static String bytesToHexString2(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);

			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	// 二进制转字符串
	public static String byte2hex(byte[] b) {
		StringBuffer sb = new StringBuffer();
		String tmp = "";
		for (int i = 0; i < b.length; i++) {
			tmp = Integer.toHexString(b[i] & 0XFF);
			if (tmp.length() == 1) {
				sb.append("0" + tmp);
			} else {
				sb.append(tmp);
			}

		}
		return sb.toString();
	}

	// 字符串转二进制
	public static byte[] hex2byte(String str) {
		if (str == null) {
			return null;
		}

		str = str.trim();
		int len = str.length();

		if (len == 0 || len % 2 == 1) {
			return null;
		}

		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	// Java将字符串转成二进制码
	public static String toBinary(String str) {
		char[] strChar = str.toCharArray();
		String result = "";
		for (int i = 0; i < strChar.length; i++) {
			result += Integer.toBinaryString(strChar[i]) + " ";
		}
		return result;
	}

	/**
	 * 将byte[]转为各种进制的字符串
	 * 
	 * @param bytes
	 *            byte[]
	 * @param radix
	 *            基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，
	 *            超出范围后变为10进制
	 * @return 转换后的字符串
	 */
	public static String binary(byte[] bytes, int radix) {
		return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
	}

	/**
	 * 二进制字符串转换为byte数组,每个字节以","隔开
	 **/
	public static byte[] conver2HexToByte(String hex2Str) {
		String[] temp = hex2Str.split(",");
		byte[] b = new byte[temp.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = Long.valueOf(temp[i], 2).byteValue();
		}
		return b;
	}

	/**
	 * 
	 * @param bytes
	 * @return 将二进制数组转换为十六进制字符串 2-16
	 */
	public static String bin2HexStr(byte[] bytes) {

		String result = "";
		String hex = "";
		for (int i = 0; i < bytes.length; i++) {
			// 字节高4位
			hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
			// 字节低4位
			hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
			result += hex; // +" "
		}
		return result;
	}

	public static byte[] ObjectToByte(Object obj) {
		byte[] bytes = null;
		try {
			// object to bytearray
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);

			bytes = bo.toByteArray();

			bo.close();
			oo.close();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		}
		return bytes;
	}

	/**
	 * 对象转Byte数组
	 * 
	 * @param obj
	 * @return
	 */
	public static byte[] objectToByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
			bytes = byteArrayOutputStream.toByteArray();

		} catch (IOException e) {
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
				}
			}
			if (byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
				}
			}

		}
		return bytes;
	}

	/**
	 * 将传入的对象系列化后，存入参数string指定的文件，并将序列化后的对象转换成十六进制字符串返回
	 * 
	 * @param object
	 *            可序列化的对象
	 * @param string
	 *            存储文件名
	 * @return string 序列化后的对象的十六进制字符串
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String writeObject(Object object) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 用于将对象转换成byte[]数组的ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		// 将对象写入ByteArrayOutputStream
		oos.writeObject(object);
		byte[] bytes = baos.toByteArray();
		// 用于将将对象存入文件的ObjectOutputStream
		/*
		 * ObjectOutputStream oos2 = new ObjectOutputStream(new
		 * FileOutputStream( strFile));
		 */
		// 将对象写入string指定的文件中
		// oos2.writeObject(object);
		oos.close();
		// oos2.close();
		baos.close();
		return bytesToHexString(bytes);

	}

	/**
	 * 
	 * @param hexString
	 * @return 将十六进制转换为二进制字节数组 16-2
	 */
	public static byte[] hexStr2BinArr(String hexString) {
		// hexString的长度对2取整，作为bytes的长度
		int len = hexString.length() / 2;
		byte[] bytes = new byte[len];
		byte high = 0;// 字节高四位
		byte low = 0;// 字节低四位
		for (int i = 0; i < len; i++) {
			// 右移四位得到高位
			high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
			low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
			bytes[i] = (byte) (high | low);// 高地位做或运算
		}
		return bytes;
	}

	/*
	 * 字符串转换为16进制字符串
	 * 
	 * @param s
	 * 
	 * @return
	 */
	public static String stringToHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/** */
	/**
	 * 把可序列化对象转换成字节数组
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static final byte[] objectToBytes(Serializable s) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream ot = new ObjectOutputStream(out);
		ot.writeObject(s);
		ot.flush();
		ot.close();
		return out.toByteArray();
	}

	/**
	 * 16进制直接转换成为字符串(无需Unicode解码)
	 * 
	 * @param hexStr
	 * @return
	 */
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	/**
	 * 字符串转换成为16进制(无需Unicode编码)
	 * 
	 * @param str
	 * @return
	 */
	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			// sb.append(' ');
		}
		return sb.toString().trim();
	}

	/**
	 * 字符串转化成为16进制字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String strTo16(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	static int readCsharpInt(InputStream in) throws IOException {
		byte[] bytes = new byte[4];
		bytes[3] = (byte) in.read();
		bytes[2] = (byte) in.read();
		bytes[1] = (byte) in.read();
		bytes[0] = (byte) in.read();
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		return buffer.getInt();
	}

	public static List<String> toListArray(String str1) {
		StringBuffer str = new StringBuffer(str1);
		List<String> strList = new ArrayList<String>();
		int start = 0;
		int end = start + 2;
		while (true) {
			if (start >= str.length()) {
				return strList;
			}
			String temp = str.substring(start, end);
			strList.add(temp);
			start = end;
			end = end + 2;
			if (end >= str.length()) {
				end = str.length();
			}
		}

	}

	public static int hexCharToDecimal(char hexChar) {
		if (hexChar >= 'A' && hexChar <= 'F')
			return hexChar - 'A' + 10;
		else
			return hexChar - '0';
	}

	public static int hexTranslateToDecimal(String s) {
		int decimal = 0;
		for (int i = 0; i < s.length(); i++) {
			char hexChar = s.charAt(i);
			// System.out.println(hexChar);
			// 对于字符串'A32',charAt(0)是A，charAt(1)是3...
			decimal = decimal * 16 + hexCharToDecimal(hexChar); /* 使用递归 */
		}
		return decimal;
	}

	/**
	 * 判断是否为json
	 * 
	 * @param content
	 * @return
	 */
	public static boolean isJson(String content) {

		try {
			JSONObject jsonStr = JSONObject.parseObject(content);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 将字符串转成ASCII
	 * 
	 * @param value
	 * @return
	 */
	public static String stringToAscii(String value) {
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i != chars.length - 1) {
				sbu.append((int) chars[i]);
			} else {
				sbu.append((int) chars[i]);
			}
		}
		return sbu.toString();
	}

	/**
	 * 校验和
	 * 
	 * @param nn
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String checkNum(String[] nn) {
		Integer sum = 0;
		// String[] nn={"AD","99","11","00","06","00","00","00"};
		for (int i = 0; i < nn.length; i++) {
			sum += Integer.parseInt(nn[i], 16);
		}
		String sud = sum.toHexString(sum);
		int d = 2;
		String lastEnd = sud.substring(sud.length() - d, sud.length());
		Integer sl = Integer.parseInt(lastEnd, 16);
		Integer ff = Integer.parseInt("ff", 16);
		Integer res = ff - sl + 1;
		String result = res.toHexString(res);
		return result;
	}

	/**
	 * 不足19字节补零
	 * 
	 * @param s
	 * @return
	 */
	public static String zero(String s) {
		int n = 38;
		String result = s + String.format("%1$0" + (n - s.length()) + "d", 0);
		System.out.println(result);
		return result;
	}

	/**
	 * 字符前补零
	 * 
	 * @param ze
	 * @return
	 */
	public static String fistZero(int ze) {
		String result = String.format("%02d", ze);
		return result;
	}

	/**
	 * 二进制字符转十六进制
	 * 
	 * @param sum
	 * @return
	 */
	public static String toHexString(String sum) {
		String resul = Integer.toHexString(Integer.valueOf(sum, 2));
		return resul;
	}

	/**
	 * 字符不满2位左边补零
	 * 
	 * @param str
	 * @param strLength
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		StringBuffer sb = null;
		while (strLen < strLength) {
			sb = new StringBuffer();
			sb.append("0").append(str);// 左补0
			// sb.append(str).append("0");//右补0
			str = sb.toString();
			strLen = str.length();
		}
		return str;
	}

	/**
	 * 字符不满4位左边补零
	 * 
	 * @param str
	 * @param strLength
	 * @return
	 */
	public static String addZeroForNumFous(String str) {
		int strLength=4;
		int strLen = str.length();
		StringBuffer sb = null;
		while (strLen < strLength) {
			sb = new StringBuffer();
			sb.append("0").append(str);// 左补0
			// sb.append(str).append("0");//右补0
			str = sb.toString();
			strLen = str.length();
		}
		return str;
	}

	
	/**
	 * 十六进制截取转换2进制
	 * @param hexString
	 * @return
	 */
	public static String hexString2binaryString(String hexString) {
		hexString = hexString.substring(1, 2);
		if (hexString == null)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
			bString += tmp;
		}
		return bString;
	}
	 /** 
     * 16进制字符串转换为字符串 
     *  
     * @param s 
     * @return 
     */  
    public static String hexStringToString(String s) {  
        if (s == null || s.equals("")) {  
            return null;  
        }  
        s = s.replace(" ", "");  
        byte[] baKeyword = new byte[s.length() / 2];  
        for (int i = 0; i < baKeyword.length; i++) {  
            try {  
                baKeyword[i] = (byte) (0xff & Integer.parseInt(  
                        s.substring(i * 2, i * 2 + 2), 16));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        try {  
            s = new String(baKeyword, "gbk");  
            new String();  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        }  
        return s;  
    }  
    /**
     * 十进制转十六进制不足四位左边补零
     * @param num
     * @return
     */
    public static String toHexTenString(String num){
    	return addZeroForNumFous(Integer.toHexString(Integer.valueOf(num)));
    }
    /**
     * 十进制截取时间转十六进制不足2位左边补零
     * @param num
     * @return
     */
    public static String toHexTimeString(String num){
    	String hour=addZeroForNum(Integer.toHexString(Integer.valueOf(num.substring(0,2))),2);
    	String min=addZeroForNum(Integer.toHexString(Integer.valueOf(num.substring(2,4))),2);
    	return hour+min;
    }
    public static String toHexDurationTime(String hour,String min){
    	String n=addZeroForNum(String.valueOf(Integer.parseInt(hour,16)),2);
    	String r=addZeroForNum(String.valueOf(Integer.parseInt(min,16)),2);
    	String rel=n+r;
    	return rel;
    }
    /**
     * 十六进制转2进制字符串8字符
     * @param hexString
     * @return
     */
    public static String hexString2binaryString2(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
          return null;
        String bString ="", tmp;
        for (int i = 0; i < hexString.length(); i++) {
          tmp ="0000"+ Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
          bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
      }
    
    /** 
     * 获取未来 第 past 天的日期 
     * @param past 
     * @return 
     */  
    public static String getFetureDate(int past) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);  
        Date today = calendar.getTime();  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        String result = format.format(today);  
        return result;  
    }  
    
	public static void main(String[] args) throws IOException {
		int count=1;
		String xlh=Binary.addZeroForNum(Integer.toHexString(count), 2);
		System.out.println(xlh);
		
		//System.out.println(MD5.getMD5("111111"+ApiConstants.PWD_KEY));
		//System.out.println(hexString2binaryString2("01"));
	/*	List<String> list=new ArrayList<String>();
		for (int i = 1; i < 8; i++) {
			String time=Binary.getFetureDate(i);
			time=time.replace("-", "");
			list.add(time);
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
			System.out.println(list.get(i));
		}*/
		//System.out.println(list);
		/*String ztz=Binary.hexString2binaryString2("01");
		String pepoehdzt=ztz.substring(0, 1);
		String jhms=ztz.substring(1,2);
		String bfzt=ztz.substring(4,5);
		String bjzt=ztz.substring(5,6);
		String hbdczt=ztz.substring(6,7);
		String gdzt=ztz.substring(7,8);*/
		//System.out.print(toHexDurationTime("0d","00"));
		//System.out.println(addZeroForNumFous("16"));
		//System.out.println(hexStringToString("31383831303238333433350000000000000000").trim());
		/*System.out.println(hexString2binaryString("31383831303238333433350000000000000000"));
		String phone1_te="10";
		String alarm_phone_num1_tel=phone1_te.substring(0, 1);
		String alarm_phone_num1_msg=phone1_te.substring(1, 2);
		System.out.println(alarm_phone_num1_tel);
		System.out.println(alarm_phone_num1_msg);*/
	}
}
