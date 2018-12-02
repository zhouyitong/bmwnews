/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 活动表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NActivity extends DataEntity<NActivity> {
	
	private static final long serialVersionUID = 1L;
	private String activityId;		// 活动ID
	private String activityName;		// 活动名称
	private Date activityStartTime;		// 活动开始时间
	private Date activityEndTime;		// 活动结束时间
	private String activityStatus;		// 活动状态0未开始1正在进行2已经结束
	private String activityBrochureImage;		// 活动封面图片
	private Date activityCreateTime;		// 活动创建时间
	private String activityCreateUser;		// 活动创建人
	private Date activityUpdateTime;		// 活动更新时间
	private String activityUpdateUser;		// 活动更新人
	private String activityRemark;		// 活动备注
	private String activityIsDelete;		// 是否删除0未删除1删除
	private Long activityVersion;		// 活动版本号
	
	public NActivity() {
		super();
	}

	public NActivity(String id){
		super(id);
	}

	@Length(min=1, max=40, message="活动ID长度必须介于 1 和 40 之间")
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	@Length(min=0, max=255, message="活动名称长度必须介于 0 和 255 之间")
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	
	@Length(min=0, max=1, message="活动状态0未开始1正在进行2已经结束长度必须介于 0 和 1 之间")
	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	
	@Length(min=0, max=40, message="活动封面图片长度必须介于 0 和 40 之间")
	public String getActivityBrochureImage() {
		return activityBrochureImage;
	}

	public void setActivityBrochureImage(String activityBrochureImage) {
		this.activityBrochureImage = activityBrochureImage;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getActivityCreateTime() {
		return activityCreateTime;
	}

	public void setActivityCreateTime(Date activityCreateTime) {
		this.activityCreateTime = activityCreateTime;
	}
	
	@Length(min=0, max=40, message="活动创建人长度必须介于 0 和 40 之间")
	public String getActivityCreateUser() {
		return activityCreateUser;
	}

	public void setActivityCreateUser(String activityCreateUser) {
		this.activityCreateUser = activityCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getActivityUpdateTime() {
		return activityUpdateTime;
	}

	public void setActivityUpdateTime(Date activityUpdateTime) {
		this.activityUpdateTime = activityUpdateTime;
	}
	
	@Length(min=0, max=40, message="活动更新人长度必须介于 0 和 40 之间")
	public String getActivityUpdateUser() {
		return activityUpdateUser;
	}

	public void setActivityUpdateUser(String activityUpdateUser) {
		this.activityUpdateUser = activityUpdateUser;
	}
	
	@Length(min=0, max=500, message="活动备注长度必须介于 0 和 500 之间")
	public String getActivityRemark() {
		return activityRemark;
	}

	public void setActivityRemark(String activityRemark) {
		this.activityRemark = activityRemark;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getActivityIsDelete() {
		return activityIsDelete;
	}

	public void setActivityIsDelete(String activityIsDelete) {
		this.activityIsDelete = activityIsDelete;
	}
	
	public Long getActivityVersion() {
		return activityVersion;
	}

	public void setActivityVersion(Long activityVersion) {
		this.activityVersion = activityVersion;
	}
	
}