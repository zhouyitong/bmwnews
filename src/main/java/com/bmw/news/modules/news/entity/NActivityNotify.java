/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 活动通知表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NActivityNotify extends DataEntity<NActivityNotify> {
	
	private static final long serialVersionUID = 1L;
	private String notifyId;		// 活动通知ID
	private String acvitityId;		// 活动ID
	private String notifyContent;		// 通知内容
	private String notifySendObject;		// 通知发送对象0所有参加活动的记者1某个记者分组2单个记者
	private String notifyIsCrontab;		// 是否定时发送0不定时1定时
	private Date notifySendTime;		// 发送时间
	private Date notifyCreateTime;		// 活动通知创建时间
	private String notifyCreateUser;		// 活动通知创建人
	private Date notifyUpdateTime;		// 活动通知更新时间
	private String notifyUpdateUser;		// 活动通知更新人
	private Long notifyVersion;		// 活动通知版本号
	
	public NActivityNotify() {
		super();
	}

	public NActivityNotify(String id){
		super(id);
	}

	@Length(min=1, max=40, message="活动通知ID长度必须介于 1 和 40 之间")
	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}
	
	@Length(min=0, max=40, message="活动ID长度必须介于 0 和 40 之间")
	public String getAcvitityId() {
		return acvitityId;
	}

	public void setAcvitityId(String acvitityId) {
		this.acvitityId = acvitityId;
	}
	
	@Length(min=0, max=500, message="通知内容长度必须介于 0 和 500 之间")
	public String getNotifyContent() {
		return notifyContent;
	}

	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
	
	@Length(min=0, max=1, message="通知发送对象0所有参加活动的记者1某个记者分组2单个记者长度必须介于 0 和 1 之间")
	public String getNotifySendObject() {
		return notifySendObject;
	}

	public void setNotifySendObject(String notifySendObject) {
		this.notifySendObject = notifySendObject;
	}
	
	@Length(min=0, max=1, message="是否定时发送0不定时1定时长度必须介于 0 和 1 之间")
	public String getNotifyIsCrontab() {
		return notifyIsCrontab;
	}

	public void setNotifyIsCrontab(String notifyIsCrontab) {
		this.notifyIsCrontab = notifyIsCrontab;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNotifySendTime() {
		return notifySendTime;
	}

	public void setNotifySendTime(Date notifySendTime) {
		this.notifySendTime = notifySendTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNotifyCreateTime() {
		return notifyCreateTime;
	}

	public void setNotifyCreateTime(Date notifyCreateTime) {
		this.notifyCreateTime = notifyCreateTime;
	}
	
	@Length(min=0, max=40, message="活动通知创建人长度必须介于 0 和 40 之间")
	public String getNotifyCreateUser() {
		return notifyCreateUser;
	}

	public void setNotifyCreateUser(String notifyCreateUser) {
		this.notifyCreateUser = notifyCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNotifyUpdateTime() {
		return notifyUpdateTime;
	}

	public void setNotifyUpdateTime(Date notifyUpdateTime) {
		this.notifyUpdateTime = notifyUpdateTime;
	}
	
	@Length(min=0, max=40, message="活动通知更新人长度必须介于 0 和 40 之间")
	public String getNotifyUpdateUser() {
		return notifyUpdateUser;
	}

	public void setNotifyUpdateUser(String notifyUpdateUser) {
		this.notifyUpdateUser = notifyUpdateUser;
	}
	
	public Long getNotifyVersion() {
		return notifyVersion;
	}

	public void setNotifyVersion(Long notifyVersion) {
		this.notifyVersion = notifyVersion;
	}
	
}