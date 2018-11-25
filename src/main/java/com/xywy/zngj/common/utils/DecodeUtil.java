package com.xywy.zngj.common.utils;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by 通子 on 2017/9/5.
 * 接口传参加密、返回值解密工具类
 */

public class DecodeUtil {
    public static String decodeParams(Map<String, Object> params, Context mContext) {
        return decodeParams(params, mContext, null);
    }
    public static String decodeParams(Map<String, Object> params, Context mContext, String token) {
        if (params == null)
            params = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();
        //添加token和time参数
        if (token != null) {
//            UserInfoBean userInfoBean = SpUtil.getInstance(mContext).getUserInfo();
//            if (!params.containsKey("token") && userInfoBean != null) {
//                params.put("token", userInfoBean.getUser_token());
//            }
            params.put("token", token);
        }
        if (!params.containsKey("time")) {
            params.put("time", System.currentTimeMillis() + "");
        }
        //排序 并 拼装成json字符串
        String[] paramsStrings = SortUtil.getParams(params);
        String paramsString = paramsStrings[0];
        //Log("paramsString", paramsStrings[0] + "======" + paramsStrings[1]);
        //加密获得sign
        String sign =MD5.getMD5(paramsString);
        //json内添加sign字段
        return sign;
    }

    public static String getDecodeJson(String returnData) {
        try {
            return new AESCrypt().decrypt(returnData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
