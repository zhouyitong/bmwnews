/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 活动邀请媒体表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NActivityMedia extends DataEntity<NActivityMedia> {
	
	private static final long serialVersionUID = 1L;
	private String activityId;		// 活动ID
	private String reporterId;		// 活动受邀记者ID
	private String reporterName;		// 活动受邀记者名称
	private String mediaId;		// 媒体ID
	private String mediaName;		// 媒体名称
	private String reporterIsInvitation;		// 是否发送邀请0未发送1已发送
	private Date reporterInvitationTime;		// 发送邀请时间
	private Date reporterResponseTime;		// 媒体记者回应时间
	private String reporterResponseResult;		// 媒体记者回应结果0本人参加1他人参加2不参加
	private String reporterResponseRemark;		// 媒体记者回应备注
	private Date reporterResponseUpdateTime;		// 媒体记者回应结果更新时间
	private String reporterResponseUpdateUser;		// 媒体记者回应结果更新人
	private String reporterIsSign;		// 媒体记者签到标识0未签到1已签到
	private Date reporterSignTime;		// 媒体记者签到时间
	
	public NActivityMedia() {
		super();
	}

	public NActivityMedia(String id){
		super(id);
	}

	@Length(min=0, max=40, message="活动ID长度必须介于 0 和 40 之间")
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	@Length(min=0, max=40, message="活动受邀记者ID长度必须介于 0 和 40 之间")
	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}
	
	@Length(min=0, max=40, message="活动受邀记者名称长度必须介于 0 和 40 之间")
	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	
	@Length(min=0, max=40, message="媒体ID长度必须介于 0 和 40 之间")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Length(min=0, max=255, message="媒体名称长度必须介于 0 和 255 之间")
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	
	@Length(min=0, max=1, message="是否发送邀请0未发送1已发送长度必须介于 0 和 1 之间")
	public String getReporterIsInvitation() {
		return reporterIsInvitation;
	}

	public void setReporterIsInvitation(String reporterIsInvitation) {
		this.reporterIsInvitation = reporterIsInvitation;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterInvitationTime() {
		return reporterInvitationTime;
	}

	public void setReporterInvitationTime(Date reporterInvitationTime) {
		this.reporterInvitationTime = reporterInvitationTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterResponseTime() {
		return reporterResponseTime;
	}

	public void setReporterResponseTime(Date reporterResponseTime) {
		this.reporterResponseTime = reporterResponseTime;
	}
	
	@Length(min=0, max=1, message="媒体记者回应结果0本人参加1他人参加2不参加长度必须介于 0 和 1 之间")
	public String getReporterResponseResult() {
		return reporterResponseResult;
	}

	public void setReporterResponseResult(String reporterResponseResult) {
		this.reporterResponseResult = reporterResponseResult;
	}
	
	@Length(min=0, max=255, message="媒体记者回应备注长度必须介于 0 和 255 之间")
	public String getReporterResponseRemark() {
		return reporterResponseRemark;
	}

	public void setReporterResponseRemark(String reporterResponseRemark) {
		this.reporterResponseRemark = reporterResponseRemark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterResponseUpdateTime() {
		return reporterResponseUpdateTime;
	}

	public void setReporterResponseUpdateTime(Date reporterResponseUpdateTime) {
		this.reporterResponseUpdateTime = reporterResponseUpdateTime;
	}
	
	@Length(min=0, max=40, message="媒体记者回应结果更新人长度必须介于 0 和 40 之间")
	public String getReporterResponseUpdateUser() {
		return reporterResponseUpdateUser;
	}

	public void setReporterResponseUpdateUser(String reporterResponseUpdateUser) {
		this.reporterResponseUpdateUser = reporterResponseUpdateUser;
	}
	
	@Length(min=0, max=1, message="媒体记者签到标识0未签到1已签到长度必须介于 0 和 1 之间")
	public String getReporterIsSign() {
		return reporterIsSign;
	}

	public void setReporterIsSign(String reporterIsSign) {
		this.reporterIsSign = reporterIsSign;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterSignTime() {
		return reporterSignTime;
	}

	public void setReporterSignTime(Date reporterSignTime) {
		this.reporterSignTime = reporterSignTime;
	}
	
}