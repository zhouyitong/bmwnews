/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 新闻简报表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NNewsBulletin extends DataEntity<NNewsBulletin> {
	
	private static final long serialVersionUID = 1L;
	private String bulletinId;		// 简报主键
	private String bulletinMediaType;		// 简报媒体类型
	private String bulletinMediaName;		// 简报媒体名字
	private String bulletinReporterId;		// 简报作者
	private String bulletinReporterName;		// 简报作者名字
	private Date bulletinPublishTime;		// 简报发布时间
	private String bulletinWordNum;		// 简报字数
	private String bulletinPage;		// 简报版面
	private String bulletinLevel;		// 简报级别
	private String bulletinTitle;		// 简报标题
	private String bulletinUrl;		// 简报url
	private String bulletinTone;		// 简报标签
	private Long bulletinShareNum;		// 简报分享数量
	private Date bulletinCreateTime;		// 简报创建时间
	private String bulletinCreateUser;		// 简报创建人
	private Date bulletinUpdateTime;		// 简报更新时间
	private String bulletinUpdateUser;		// 简报更新人
	private String bulletinIsDelete;		// 是否删除0未删除1删除
	private Long bulletinVersion;		// 简报版本号
	
	public NNewsBulletin() {
		super();
	}

	public NNewsBulletin(String id){
		super(id);
	}

	@Length(min=0, max=40, message="简报主键长度必须介于 0 和 40 之间")
	public String getBulletinId() {
		return bulletinId;
	}

	public void setBulletinId(String bulletinId) {
		this.bulletinId = bulletinId;
	}
	
	@Length(min=0, max=40, message="简报媒体类型长度必须介于 0 和 40 之间")
	public String getBulletinMediaType() {
		return bulletinMediaType;
	}

	public void setBulletinMediaType(String bulletinMediaType) {
		this.bulletinMediaType = bulletinMediaType;
	}
	
	@Length(min=0, max=255, message="简报媒体名字长度必须介于 0 和 255 之间")
	public String getBulletinMediaName() {
		return bulletinMediaName;
	}

	public void setBulletinMediaName(String bulletinMediaName) {
		this.bulletinMediaName = bulletinMediaName;
	}
	
	@Length(min=0, max=40, message="简报作者长度必须介于 0 和 40 之间")
	public String getBulletinReporterId() {
		return bulletinReporterId;
	}

	public void setBulletinReporterId(String bulletinReporterId) {
		this.bulletinReporterId = bulletinReporterId;
	}
	
	@Length(min=0, max=40, message="简报作者名字长度必须介于 0 和 40 之间")
	public String getBulletinReporterName() {
		return bulletinReporterName;
	}

	public void setBulletinReporterName(String bulletinReporterName) {
		this.bulletinReporterName = bulletinReporterName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBulletinPublishTime() {
		return bulletinPublishTime;
	}

	public void setBulletinPublishTime(Date bulletinPublishTime) {
		this.bulletinPublishTime = bulletinPublishTime;
	}
	
	@Length(min=0, max=11, message="简报字数长度必须介于 0 和 11 之间")
	public String getBulletinWordNum() {
		return bulletinWordNum;
	}

	public void setBulletinWordNum(String bulletinWordNum) {
		this.bulletinWordNum = bulletinWordNum;
	}
	
	@Length(min=0, max=40, message="简报版面长度必须介于 0 和 40 之间")
	public String getBulletinPage() {
		return bulletinPage;
	}

	public void setBulletinPage(String bulletinPage) {
		this.bulletinPage = bulletinPage;
	}
	
	@Length(min=0, max=40, message="简报级别长度必须介于 0 和 40 之间")
	public String getBulletinLevel() {
		return bulletinLevel;
	}

	public void setBulletinLevel(String bulletinLevel) {
		this.bulletinLevel = bulletinLevel;
	}
	
	@Length(min=0, max=255, message="简报标题长度必须介于 0 和 255 之间")
	public String getBulletinTitle() {
		return bulletinTitle;
	}

	public void setBulletinTitle(String bulletinTitle) {
		this.bulletinTitle = bulletinTitle;
	}
	
	@Length(min=0, max=255, message="简报url长度必须介于 0 和 255 之间")
	public String getBulletinUrl() {
		return bulletinUrl;
	}

	public void setBulletinUrl(String bulletinUrl) {
		this.bulletinUrl = bulletinUrl;
	}
	
	@Length(min=0, max=255, message="简报标签长度必须介于 0 和 255 之间")
	public String getBulletinTone() {
		return bulletinTone;
	}

	public void setBulletinTone(String bulletinTone) {
		this.bulletinTone = bulletinTone;
	}
	
	public Long getBulletinShareNum() {
		return bulletinShareNum;
	}

	public void setBulletinShareNum(Long bulletinShareNum) {
		this.bulletinShareNum = bulletinShareNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBulletinCreateTime() {
		return bulletinCreateTime;
	}

	public void setBulletinCreateTime(Date bulletinCreateTime) {
		this.bulletinCreateTime = bulletinCreateTime;
	}
	
	@Length(min=0, max=40, message="简报创建人长度必须介于 0 和 40 之间")
	public String getBulletinCreateUser() {
		return bulletinCreateUser;
	}

	public void setBulletinCreateUser(String bulletinCreateUser) {
		this.bulletinCreateUser = bulletinCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBulletinUpdateTime() {
		return bulletinUpdateTime;
	}

	public void setBulletinUpdateTime(Date bulletinUpdateTime) {
		this.bulletinUpdateTime = bulletinUpdateTime;
	}
	
	@Length(min=0, max=40, message="简报更新人长度必须介于 0 和 40 之间")
	public String getBulletinUpdateUser() {
		return bulletinUpdateUser;
	}

	public void setBulletinUpdateUser(String bulletinUpdateUser) {
		this.bulletinUpdateUser = bulletinUpdateUser;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getBulletinIsDelete() {
		return bulletinIsDelete;
	}

	public void setBulletinIsDelete(String bulletinIsDelete) {
		this.bulletinIsDelete = bulletinIsDelete;
	}
	
	public Long getBulletinVersion() {
		return bulletinVersion;
	}

	public void setBulletinVersion(Long bulletinVersion) {
		this.bulletinVersion = bulletinVersion;
	}
	
}