package com.xywy.zngj.web.controller;

import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.xywy.zngj.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xywy.zngj.common.utils.AESCryptUtil;
import com.xywy.zngj.common.utils.DateUtil;
import com.xywy.zngj.common.utils.DateUtils;
import com.xywy.zngj.common.utils.DecodeUtil;
import com.xywy.zngj.common.utils.FileUtils;
import com.xywy.zngj.common.utils.JedisUtils;
import com.xywy.zngj.common.utils.JsonMapper;
import com.xywy.zngj.common.utils.MD5;
import com.xywy.zngj.common.utils.RSACryptoUtil;
import com.xywy.zngj.common.utils.ResultUtil;
import com.xywy.zngj.common.utils.SmsUtils;
import com.xywy.zngj.common.utils.UploadUtils;
import com.xywy.zngj.web.enumtype.ApiConstants;
import com.xywy.zngj.web.enumtype.ApiConstants.ResponseVoStatus;
import com.xywy.zngj.web.enumtype.SocketConstants;
import com.xywy.zngj.web.enumtype.SocketRemoteConstants;

@RestController
@RequestMapping(value = "/api/App/")
public class ApiWapController {

    /**
     * 发送验证码
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sendPhoneCodeApp", method = RequestMethod.POST)
    @ResponseBody
    public String sendPhoneCodeApp(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String param = request.getParameter("request");
        String code = SmsUtils.getFourRandom();
        //String param = "h8fUcVl3mhIoa2oTIdn0JuvRDPWycMAewgNMmbZy+bB5Lzr0I6vGr2JRwYrLC7V17Jqim/6cdH/r59s0aH0MYQeQjRnuy20A0T8My2wDOeoNAiEeQvK1T3dOO9rxyEFHYZuT4kKT1aSu6QC9G40DRMOlEAMNWgiFwxLzh/6x6icapYmfR0t3t8Hs+jnHKRTAiGkpnc9FWnLSR/IQKRHYrYp5STErGLLZOIcJGy9ZPMJWrMyIyJzBetqA5oLMIxu3QrvHE+3Km2+0kliZkEhR+mlChrWk9V8k6oayVNSlXBBtcgX/f4G0uNadrCmBNZquAtSutYOkYW23ooyDWKGC6g==";
        try {
            Map paramMap = JsonMapper.fromJson(AESCryptUtil.decrypt(param), Map.class);
            String phone = (String) paramMap.get("user_phone");
            String sign = (String) paramMap.get("sign");
            String time = (String) paramMap.get("time");
            String token = (String) paramMap.get("token");
            Integer now = DateUtils.getIntegerTime(new Date());
            //System.out.println(time-start);
           /* if (now - parseIntger(time) > 30) {
                return ResultUtil.returnData("0", "请求超时", null);
            }*/
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("time", time);
            map.put("user_phone", phone);
            if (!"".equals(token) && !"null".equals(token) && token != null) map.put("token", token);
            String singMd5 = RSACryptoUtil.decryptByPrivateKey(sign);
            String singMd51 = DecodeUtil.decodeParams(map, null, null);
            if (!singMd5.equals(singMd51)) {
                return ResultUtil.returnData("2", "数字签名不正确", null);
            }
            SmsUtils.sendSms(phone, code);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            return "";
        }
        return ResultUtil.returnData("1", "获取短信验证码成功", code);
    }


    /**
     * 单图片上传
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UploadUtils upload = new UploadUtils();
        String[] uploadFile = upload.uploadFile(request);
        if (!"true".equals(uploadFile[0])) {
            return ResultUtil.returnData("2", "图片过大，请重新上传", uploadFile[0]);
        }
        if (!"true".equals(uploadFile[1])) {
            return ResultUtil.returnData("2", "上传文件失败", uploadFile[1]);
        }

        return ResultUtil.returnData("1", "上传成功", StringUtils.isNoneEmpty(uploadFile[4]) ? uploadFile[4] : null);
    }

  
}




