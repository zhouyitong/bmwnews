package com.xywy.zngj.common.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
import com.xywy.zngj.common.vo.UserInfo;


public class WxUtil {
	private static Log log = LogFactory.getLog(WxUtil.class);
	
	public static final String CORP_ID = "wxec1c59c8edcf1662";
	public static final String SECRET = "x1Gclc8J-FwnwyWplRrEw72G7ZM0xXXmAD1LXbseNBEo1r-OP3fqUdMwSg9SN1uM";
	public static String AccessTokenURL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
	public static String GETUSERINFOURL = "https://qyapi.weixin.qq.com/cgi-bin/user/get";
	public static String GETCODEURL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
	
	//b82e68782fc17b27bccaf82ec1d0013e
	//HE6VYDhCj-yqn1tjBP7UcdHW_7cQvUV4QI1wrkRqJsp_J4dASJ6dyE-0O-KWEoaL
	public static void main(String args[]){
//		getUserInfoByRequest(null);
//		getAcessToken()  ;
//		getUserIdByCode("b82e68782fc17b27bccaf82ec1d0013e");
		
//		String res = "{\"errcode\":0,\"errmsg\":\"ok\",\"userid\":\"zqh\",\"name\":\"邹清??\",\"department\":[10],\"mobile\":\"13621287709\",\"gender\":\"2\",\"email\":\"153070139@qq.com\",\"avatar\":\"http://shp.qpic.cn/bizmp/RK9FSR9z4fHdpyaT9H5kIafz5Yw5bXwojeqtPKo4Avic9ojYea35PKw/\",\"status\":1,\"extattr\":{\"attrs\":[]}}" ;
//		JSONObject jsonobject = JSONObject.parseObject(res);
//		String userid = jsonobject.getString("userid");
//		System.out.println(userid);
		getUserInfoByUserId("aili") ;
	}
	
	public static UserInfo getUserInfoByRequest(HttpServletRequest request) {
		String code = request.getParameter("code");
		log.info("getUserInfoByRequest:"+code);
		if(StringUtils.isBlank(code)){
			return null;
		}
		String userid = getUserIdByCode(code);
		if(userid==null)   return null;
		UserInfo userInfo = getUserInfoByUserId(userid);
		if(StringUtils.isBlank(userInfo.getUserid())){
			return null;
		}
		return userInfo;
	}

	/**
	 * http://qydev.weixin.qq.com/wiki/index.php?title=OAuth验证接口 根据code获取成员信息
	 * 
	 * @param code
	 * @return
	 */
	public static String getUserIdByCode(String code) {
		Map<String, String> map = new HashMap<String, String>();
		String access_token = getAcessToken();
//		String access_token = "HE6VYDhCj-yqn1tjBP7UcdHW_7cQvUV4QI1wrkRqJsp_J4dASJ6dyE-0O-KWEoaL";
		map.put("access_token", access_token);
		map.put("code", code);  
		// 开始调用接口
//		String res = HttpClient.MethodPostResponse(GETCODEURL, map);
		String url = GETCODEURL+"?access_token="+access_token+"&code="+code;
		String res = HttpUrlConnection.urlConnection(url, "") ;
		log.info("getUserIdByCode:"+res);
		JSONObject jsonobject = JSONObject.parseObject(res);
		String userid = jsonobject.getString("UserId");
		return userid;
	}

	/**
	 * http://qydev.weixin.qq.com/wiki/index.php?title=管理成员 获取成员
	 * 
	 * @param userId
	 * @return
	 */
	public static UserInfo getUserInfoByUserId(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		UserInfo userInfor = new UserInfo();
		String access_token = getAcessToken();
		map.put("access_token", access_token);
		map.put("userid", userId);
		// 开始调用接口
//		String res = HttpClient.MethodPostResponse(GETUSERINFOURL, map);
		String url = GETUSERINFOURL+"?access_token="+access_token+"&userid="+userId;
		String res = HttpUrlConnection.urlConnection(url, "") ;
		log.info("getUserInfoByUserId:"+res);
		JSONObject jsonobject = JSONObject.parseObject(res);
		String mobile = jsonobject.getString("mobile");
		String name = jsonobject.getString("name");
		String userid = jsonobject.getString("userid");
		userInfor.setMobile(mobile);
		userInfor.setName(name);
		userInfor.setUserid(userid);
		log.info("name:"+name);
		return userInfor;
	}

	/**
	 * http://qydev.weixin.qq.com/wiki/index.php?title=主动调用 获取AccessToken
	 * 
	 * @return
	 */
	public static String getAcessToken() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("corpid", CORP_ID);
		map.put("corpsecret", SECRET);
		// 开始调用接口
		//String res = HttpClient.MethodPostResponse(AccessTokenURL, map);
		String url = AccessTokenURL+"?corpid="+CORP_ID+"&corpsecret="+SECRET;
		String res = HttpUrlConnection.urlConnection(url, "") ;
		log.info("getAcessToken:"+res);
		JSONObject jsonobject = JSONObject.parseObject(res);
		String token = jsonobject.getString("access_token");
		log.info("token:"+token);
		if (token != null) {
			return token;
		} else {
			return "";
		}

	}
	
}
