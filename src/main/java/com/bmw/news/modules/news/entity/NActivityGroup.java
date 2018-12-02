/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 活动分组表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NActivityGroup extends DataEntity<NActivityGroup> {
	
	private static final long serialVersionUID = 1L;
	private String groupId;		// 活动媒体分组主键
	private String activityId;		// 活动ID
	private String groupName;		// 分组名字
	private String reporterId;		// 媒体记者ID
	private String reporterName;		// 媒体记者名字
	private String mediaId;		// 媒体记者所属媒体ID
	private String mediaName;		// 媒体接着所属媒体名字
	private Date groupCreateTime;		// 分组创建时间
	private String groupCreateUser;		// 分组创建人
	private Date groupUpdateTime;		// 分组更新时间
	private String groupUpdateUser;		// 分组更新人
	private String groupIsDelete;		// 是否删除0未删除1删除
	private String groupIsUseable;		// 分组是否可用
	
	public NActivityGroup() {
		super();
	}

	public NActivityGroup(String id){
		super(id);
	}

	@Length(min=1, max=40, message="活动媒体分组主键长度必须介于 1 和 40 之间")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@Length(min=0, max=40, message="活动ID长度必须介于 0 和 40 之间")
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	@Length(min=0, max=40, message="分组名字长度必须介于 0 和 40 之间")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Length(min=0, max=40, message="媒体记者ID长度必须介于 0 和 40 之间")
	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}
	
	@Length(min=0, max=40, message="媒体记者名字长度必须介于 0 和 40 之间")
	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	
	@Length(min=0, max=40, message="媒体记者所属媒体ID长度必须介于 0 和 40 之间")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Length(min=0, max=255, message="媒体接着所属媒体名字长度必须介于 0 和 255 之间")
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGroupCreateTime() {
		return groupCreateTime;
	}

	public void setGroupCreateTime(Date groupCreateTime) {
		this.groupCreateTime = groupCreateTime;
	}
	
	@Length(min=0, max=40, message="分组创建人长度必须介于 0 和 40 之间")
	public String getGroupCreateUser() {
		return groupCreateUser;
	}

	public void setGroupCreateUser(String groupCreateUser) {
		this.groupCreateUser = groupCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGroupUpdateTime() {
		return groupUpdateTime;
	}

	public void setGroupUpdateTime(Date groupUpdateTime) {
		this.groupUpdateTime = groupUpdateTime;
	}
	
	@Length(min=0, max=40, message="分组更新人长度必须介于 0 和 40 之间")
	public String getGroupUpdateUser() {
		return groupUpdateUser;
	}

	public void setGroupUpdateUser(String groupUpdateUser) {
		this.groupUpdateUser = groupUpdateUser;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getGroupIsDelete() {
		return groupIsDelete;
	}

	public void setGroupIsDelete(String groupIsDelete) {
		this.groupIsDelete = groupIsDelete;
	}
	
	@Length(min=0, max=1, message="分组是否可用长度必须介于 0 和 1 之间")
	public String getGroupIsUseable() {
		return groupIsUseable;
	}

	public void setGroupIsUseable(String groupIsUseable) {
		this.groupIsUseable = groupIsUseable;
	}
	
}