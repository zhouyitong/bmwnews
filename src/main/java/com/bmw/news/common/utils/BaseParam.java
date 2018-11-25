package com.bmw.news.common.utils;

public class BaseParam {
   
	private int type;//类型  0 心跳 1 注册  2 发消息
	private  String  myid; //自己的id
	private  String sentid; //发送的用户
	private  String sentMsg;  // 发送的消息
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMyid() {
		return myid;
	}
	public void setMyid(String myid) {
		this.myid = myid;
	}
	public String getSentid() {
		return sentid;
	}
	public void setSentid(String sentid) {
		this.sentid = sentid;
	}
	public String getSentMsg() {
		return sentMsg;
	}
	public void setSentMsg(String sentMsg) {
		this.sentMsg = sentMsg;
	}

	
	
}
