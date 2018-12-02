/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 活动邀请函表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NActivityInvitation extends DataEntity<NActivityInvitation> {
	
	private static final long serialVersionUID = 1L;
	private String invitationId;		// 邀请函ID
	private String activityId;		// 活动ID
	private String invitationTitle;		// 邀请函标题
	private String invitationContent;		// 邀请函正文
	private String invitationCreateUser;		// 邀请函创建人
	private Date invitationCreateTime;		// 邀请函创建时间
	private String invitationUpdateUser;		// 邀请函更新人
	private Date invitationUpdateTime;		// 邀请函更新时间
	private String invitationIsDeleteCopy1;		// 是否可用0不可用1可用
	private String invitationIsDelete;		// 是否删除0未删除1删除
	private Long invitationVersion;		// 邀请函版本号
	
	public NActivityInvitation() {
		super();
	}

	public NActivityInvitation(String id){
		super(id);
	}

	@Length(min=0, max=40, message="邀请函ID长度必须介于 0 和 40 之间")
	public String getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	
	@Length(min=0, max=40, message="活动ID长度必须介于 0 和 40 之间")
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	@Length(min=0, max=255, message="邀请函标题长度必须介于 0 和 255 之间")
	public String getInvitationTitle() {
		return invitationTitle;
	}

	public void setInvitationTitle(String invitationTitle) {
		this.invitationTitle = invitationTitle;
	}
	
	public String getInvitationContent() {
		return invitationContent;
	}

	public void setInvitationContent(String invitationContent) {
		this.invitationContent = invitationContent;
	}
	
	@Length(min=0, max=40, message="邀请函创建人长度必须介于 0 和 40 之间")
	public String getInvitationCreateUser() {
		return invitationCreateUser;
	}

	public void setInvitationCreateUser(String invitationCreateUser) {
		this.invitationCreateUser = invitationCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInvitationCreateTime() {
		return invitationCreateTime;
	}

	public void setInvitationCreateTime(Date invitationCreateTime) {
		this.invitationCreateTime = invitationCreateTime;
	}
	
	@Length(min=0, max=40, message="邀请函更新人长度必须介于 0 和 40 之间")
	public String getInvitationUpdateUser() {
		return invitationUpdateUser;
	}

	public void setInvitationUpdateUser(String invitationUpdateUser) {
		this.invitationUpdateUser = invitationUpdateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInvitationUpdateTime() {
		return invitationUpdateTime;
	}

	public void setInvitationUpdateTime(Date invitationUpdateTime) {
		this.invitationUpdateTime = invitationUpdateTime;
	}
	
	@Length(min=0, max=1, message="是否可用0不可用1可用长度必须介于 0 和 1 之间")
	public String getInvitationIsDeleteCopy1() {
		return invitationIsDeleteCopy1;
	}

	public void setInvitationIsDeleteCopy1(String invitationIsDeleteCopy1) {
		this.invitationIsDeleteCopy1 = invitationIsDeleteCopy1;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getInvitationIsDelete() {
		return invitationIsDelete;
	}

	public void setInvitationIsDelete(String invitationIsDelete) {
		this.invitationIsDelete = invitationIsDelete;
	}
	
	public Long getInvitationVersion() {
		return invitationVersion;
	}

	public void setInvitationVersion(Long invitationVersion) {
		this.invitationVersion = invitationVersion;
	}
	
}