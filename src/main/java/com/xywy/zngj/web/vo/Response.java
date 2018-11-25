package com.xywy.zngj.web.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import com.xywy.zngj.web.enumtype.ResponseStatus;

/**
 * Author: lyp
 * Create Date: 2018/1/27
 * Description:
 */
public class Response implements Serializable {
    private static final long serialVersionUID = -3226060294501599199L;

    private int status;

    private String message = "";

    private String date = String.valueOf(System.currentTimeMillis());

    private Object data;

    private Response() {

    }

    private Response(ResponseStatus responseStatus) {
        this.status = responseStatus.value();
        this.message = responseStatus.message();
    }

    private Response(int code, String message) {
        this.status = code;
        this.message = message;
    }

    public static Response success() {
        Response response = new Response(ResponseStatus.Success);
        response.status = ResponseStatus.Success.value();
        response.message = ResponseStatus.Success.message();
        return response;
    }

    public static Response successObject(Object data) {
        Response response = new Response(ResponseStatus.Success);
        response.data = data;
        return response;
    }
    public Response successList(final Object data){
        this.status = ResponseStatus.Success.value();
        this.message = ResponseStatus.Success.message();
        this.data = new HashMap<String,Object>(){
            private static final long serialVersionUID = 8257534655516628778L;
            {put("list",data);}
        };
        return this;
    }
    @SuppressWarnings({ "rawtypes", "serial" })
    public static Response successCollection(final Collection data) {
        Response response = new Response(ResponseStatus.Success);
        response.data = new HashMap<String, Object>() {
            {
                put("list", data);
            }
        };
        return response;
    }

    public static Response failure() {
        return new Response(ResponseStatus.ServerInternalError);
    }

    public static Response failure(ResponseStatus responseStatus) {
        return new Response(responseStatus);
    }

    public static Response failure(String message) {
        Response response = new Response();
        response.status = ResponseStatus.ServerInternalError.value();
        response.message = message;
        return response;
    }

    public static Response failure(int code, String message) {
        return new Response(code, message);
    }

    public static Response badRequest(String message){
        Response response = new Response();
        response.status = ResponseStatus.BadRequest.value();
        response.message = message;
        return response;
    }

    public static Response badRequest(String message,Object data){
        Response response = new Response();
        response.status = ResponseStatus.BadRequest.value();
        response.message = message;
        response.data = data;
        return response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessages() {
        return message;
    }

    public void setMessages(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
