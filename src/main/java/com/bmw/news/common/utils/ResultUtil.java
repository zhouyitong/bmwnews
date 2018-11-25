package com.bmw.news.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bmw.news.web.enumtype.ApiConstants;

/**
 * result  返回结果集
 * code  返回 0 失败  1 成功
 * message 具体失败原因  或者成功
 * resultMap 存放code message
 * bodyMap 存放具体返回数据，无数据放null
 *  接口返回参数工具类
 */
public class ResultUtil {
    /**
     *
     * @param code
     * @param message
     * @param bodyMap
     * @return
     * @throws Exception 
     */
    public static String returnDataMap(String code,String message,Object bodyMap) throws Exception{
        Map<String,Object> result = new HashMap<String,Object>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", code);
        resultMap.put("msg", message);
        if (null != bodyMap ) {
        	resultMap.put("data", bodyMap);
        }else{
        	resultMap.put("data", new HashMap());
        }
        try {
			String encrypt = AESCryptUtil.encrypt(JsonMapper.toJson(resultMap));
			result.put("response", encrypt);
			return JsonMapper.toJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> result1 = new HashMap<String,Object>();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("status", ApiConstants.ResponseVoStatus.RequestTimeOut.getCode());
			map.put("msg", ApiConstants.ResponseVoStatus.getMessageByValue(ApiConstants.ResponseVoStatus.RequestTimeOut.getCode()));
			map.put("data", "");
			String encrypt = AESCryptUtil.encrypt(JsonMapper.toJson(map));
			result1.put("response", encrypt);
			return JsonUtil.toJson(result1);
		} 
    }
    /**
     *
     * @param code
     * @param message
     * @param bodyMap
     * @return
     * @throws Exception 
     */
    public static String returnData(String code,String message,Object bodyMap) throws Exception{
    	Map<String,Object> result = new HashMap<String,Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("status", code);
    	resultMap.put("msg", message);
    	if (null != bodyMap ) {
    		resultMap.put("data", bodyMap);
    	}else{
    		resultMap.put("data", "");
    	}
    	try {
    		String encrypt = AESCryptUtil.encrypt(JsonMapper.toJson(resultMap));
    		result.put("response", encrypt);
    		return JsonMapper.toJson(result);
    	} catch (Exception e) {
    		e.printStackTrace();
    		Map<String,Object> result1 = new HashMap<String,Object>();
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("status", ApiConstants.ResponseVoStatus.RequestTimeOut.getCode());
    		map.put("msg", ApiConstants.ResponseVoStatus.getMessageByValue(ApiConstants.ResponseVoStatus.RequestTimeOut.getCode()));
    		map.put("data", "");
    		String encrypt = AESCryptUtil.encrypt(JsonMapper.toJson(map));
    		result1.put("response", encrypt);
    		return JsonUtil.toJson(result1);
    	} 
    }
    /**
     *
     * @param code
     * @param message
     * @param bodyMap
     * @return
     * @throws Exception 
     */
    public static String returnDataList(String code,String message,Object bodyMap) throws Exception{
    	Map<String,Object> result = new HashMap<String,Object>();
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("status", code);
    	resultMap.put("msg", message);
    	if (null != bodyMap ) {
    		resultMap.put("data", bodyMap);
    	}else{
    		resultMap.put("data", new ArrayList());
    	}
    	try {
    		String encrypt = AESCryptUtil.encrypt(JsonMapper.toJson(resultMap));
    		result.put("response", encrypt);
    		return JsonMapper.toJson(result);
    	} catch (Exception e) {
    		e.printStackTrace();
    		Map<String,Object> result1 = new HashMap<String,Object>();
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("status", ApiConstants.ResponseVoStatus.RequestTimeOut.getCode());
    		map.put("msg", ApiConstants.ResponseVoStatus.getMessageByValue(ApiConstants.ResponseVoStatus.RequestTimeOut.getCode()));
    		map.put("data", "");
    		String encrypt = AESCryptUtil.encrypt(JsonMapper.toJson(map));
    		result1.put("response", encrypt);
    		return JsonUtil.toJson(result1);
    	} 
    }
}
