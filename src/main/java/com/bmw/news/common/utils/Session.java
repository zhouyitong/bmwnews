package com.bmw.news.common.utils;

import io.netty.channel.Channel;

public class Session {
    //Session的唯一标识
    private String id;
    //和Session相关的channel,通过它向客户端回送数据
    private Channel channel = null;
    //上次通信时间
    private long lastCommunicateTimeStamp = 0l;

    //快速构建一个新的Session    
    public static Session buildSession(Channel channel,String hostId) {
        Session session = new Session();
        session.setChannel(channel);

        //此处暂且使用netty生成的类似UUID的字符串,来标识一个session
        session.setId(hostId);
        session.setLastCommunicateTimeStamp(System.currentTimeMillis());
        return session;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public long getLastCommunicateTimeStamp() {
		return lastCommunicateTimeStamp;
	}

	public void setLastCommunicateTimeStamp(long lastCommunicateTimeStamp) {
		this.lastCommunicateTimeStamp = lastCommunicateTimeStamp;
	}

    // getter,setter
    
}
