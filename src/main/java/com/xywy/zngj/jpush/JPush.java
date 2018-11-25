package com.xywy.zngj.jpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.google.common.collect.Maps;
import com.xywy.zngj.common.utils.DateUtils;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/24.
 */
public class JPush {

    //极光推送>>Android
    public static void jpushAndroid(Map<String, String> parm) {
        String userid = parm.get("userid");
        Audience all = Audience.all();
        if(userid.equals("0")){
            all = Audience.all();
        }else{
            all = Audience.alias(userid);
        }
        String appKey = "4a8899dfd09fe2a92195486b";
        String masterSecret = "d0a220b5d8f83c72e3b3a3cf";
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())//指定android平台的用户
                .setAudience(all)//你项目中的所有用户
//                .setNotification(Notification.android(parm.get("msg"), "这是title", parm))
//                .setNotification(Notification.newBuilder()
//                        .addPlatformNotification(AndroidNotification.newBuilder()
//                                .addExtras(parm)
//                                .setAlert(parm.get("msg"))
//                                .build()).build())
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            System.out.println("e = " + e);
        } catch (APIRequestException e) {
            System.out.println("e = " + e);
        }
    }


    //极光推送>>ios
    public static  void jpushIOS(Map<String, String> parm) {
        String appKey = "4a8899dfd09fe2a92195486b";
        String masterSecret = "d0a220b5d8f83c72e3b3a3cf";
        String userid = parm.get("userid");
        Audience all = Audience.all();
        if(userid.equals("0")){
            all = Audience.all();
        }else{
            all = Audience.alias(userid);
        }
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.ios())//ios平台的用户
                .setAudience(all)//所有用户
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(parm.get("msg"))
                                .setBadge(+1)
                                .setSound("happy")//这里是设置提示音
                                .addExtras(parm)
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);

        } catch (APIConnectionException e) {
            System.out.println("e = " + e);
        } catch (APIRequestException e) {
            System.out.println("e = " + e);
        }
    }

    //极光推送>>ios
    public static  void jpushIOSCustom(Map<String, String> parm) {
        String appKey = "4a8899dfd09fe2a92195486b";
        String masterSecret = "d0a220b5d8f83c72e3b3a3cf";
        String userid = parm.get("userid");
        Audience all = Audience.all();
        if(userid.equals("0")){
            all = Audience.all();
        }else{
            all = Audience.alias(userid);
        }
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.ios())//ios平台的用户
                .setAudience(all)//所有用户
//                .setNotification(Notification.newBuilder()
//                        .addPlatformNotification(IosNotification.newBuilder()
//                                .setAlert(parm.get("msg"))
//                                .setBadge(+1)
//                                .setSound("happy")//这里是设置提示音
//                                .addExtras(parm)
//                                .build())
//                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);

        } catch (APIConnectionException e) {
            System.out.println("e = " + e);
        } catch (APIRequestException e) {
            System.out.println("e = " + e);
        }


    }


    public static void main(String[] args) {
        Map<String, String> parm = Maps.newHashMap();
        //文章标题
        parm.put("Atitle", DateUtils.getDate());
        //设置提示信息,内容是文章标题
        parm.put("msg","null");
        //调用ios的
        parm.put("userid","116");
        try {
            JPush.jpushIOS(parm);
            //然后调用安卓的
//            JPush.jpushAndroid(parm);
        }catch (Exception e){

        }
    }
}
