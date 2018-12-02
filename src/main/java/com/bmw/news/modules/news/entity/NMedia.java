/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 媒体信息Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NMedia extends DataEntity<NMedia> {
	
	private static final long serialVersionUID = 1L;
	private String mediaId;		// 媒体主键
	private String mediaLevel;		// 媒体级别
	private String mediaRegion;		// 媒体区域
	private String mediaCity;		// 媒体所属城市
	private String mediaName;		// 媒体名字
	private String mediaType;		// 媒体类型
	private String mediaCategory;		// 媒体类别
	private String mediaGroup;		// 所属媒体集团
	private String mediaPage;		// 媒体版面
	private String mediaChannel;		// 媒体频道
	private String mediaIsImportant;		// 是否为重要媒体0不重要1重要
	private String mediaIsDispatch;		// 是否允许发稿0不允许1允许
	private String mediaLogoImage;		// 媒体标志图片
	private String mediaContactAddress;		// 媒体联系地址
	private String mediaContactTel;		// 媒体联系电话
	private String mediaCreateUser;		// 记录创建人
	private Date mediaCreateTime;		// 记录创建时间
	private String mediaUpdateUser;		// 记录更新人
	private Date mediaUpdateTime;		// 记录更新时间
	private String mediaIsDelete;		// 是否删除0未删除1删除
	
	public NMedia() {
		super();
	}

	public NMedia(String id){
		super(id);
	}

	@Length(min=1, max=40, message="媒体主键长度必须介于 1 和 40 之间")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Length(min=0, max=40, message="媒体级别长度必须介于 0 和 40 之间")
	public String getMediaLevel() {
		return mediaLevel;
	}

	public void setMediaLevel(String mediaLevel) {
		this.mediaLevel = mediaLevel;
	}
	
	@Length(min=0, max=40, message="媒体区域长度必须介于 0 和 40 之间")
	public String getMediaRegion() {
		return mediaRegion;
	}

	public void setMediaRegion(String mediaRegion) {
		this.mediaRegion = mediaRegion;
	}
	
	@Length(min=0, max=40, message="媒体所属城市长度必须介于 0 和 40 之间")
	public String getMediaCity() {
		return mediaCity;
	}

	public void setMediaCity(String mediaCity) {
		this.mediaCity = mediaCity;
	}
	
	@Length(min=0, max=255, message="媒体名字长度必须介于 0 和 255 之间")
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	
	@Length(min=0, max=40, message="媒体类型长度必须介于 0 和 40 之间")
	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	@Length(min=0, max=40, message="媒体类别长度必须介于 0 和 40 之间")
	public String getMediaCategory() {
		return mediaCategory;
	}

	public void setMediaCategory(String mediaCategory) {
		this.mediaCategory = mediaCategory;
	}
	
	@Length(min=0, max=255, message="所属媒体集团长度必须介于 0 和 255 之间")
	public String getMediaGroup() {
		return mediaGroup;
	}

	public void setMediaGroup(String mediaGroup) {
		this.mediaGroup = mediaGroup;
	}
	
	@Length(min=0, max=40, message="媒体版面长度必须介于 0 和 40 之间")
	public String getMediaPage() {
		return mediaPage;
	}

	public void setMediaPage(String mediaPage) {
		this.mediaPage = mediaPage;
	}
	
	@Length(min=0, max=40, message="媒体频道长度必须介于 0 和 40 之间")
	public String getMediaChannel() {
		return mediaChannel;
	}

	public void setMediaChannel(String mediaChannel) {
		this.mediaChannel = mediaChannel;
	}
	
	@Length(min=0, max=1, message="是否为重要媒体0不重要1重要长度必须介于 0 和 1 之间")
	public String getMediaIsImportant() {
		return mediaIsImportant;
	}

	public void setMediaIsImportant(String mediaIsImportant) {
		this.mediaIsImportant = mediaIsImportant;
	}
	
	@Length(min=0, max=1, message="是否允许发稿0不允许1允许长度必须介于 0 和 1 之间")
	public String getMediaIsDispatch() {
		return mediaIsDispatch;
	}

	public void setMediaIsDispatch(String mediaIsDispatch) {
		this.mediaIsDispatch = mediaIsDispatch;
	}
	
	@Length(min=0, max=255, message="媒体标志图片长度必须介于 0 和 255 之间")
	public String getMediaLogoImage() {
		return mediaLogoImage;
	}

	public void setMediaLogoImage(String mediaLogoImage) {
		this.mediaLogoImage = mediaLogoImage;
	}
	
	@Length(min=0, max=255, message="媒体联系地址长度必须介于 0 和 255 之间")
	public String getMediaContactAddress() {
		return mediaContactAddress;
	}

	public void setMediaContactAddress(String mediaContactAddress) {
		this.mediaContactAddress = mediaContactAddress;
	}
	
	@Length(min=0, max=40, message="媒体联系电话长度必须介于 0 和 40 之间")
	public String getMediaContactTel() {
		return mediaContactTel;
	}

	public void setMediaContactTel(String mediaContactTel) {
		this.mediaContactTel = mediaContactTel;
	}
	
	@Length(min=0, max=40, message="记录创建人长度必须介于 0 和 40 之间")
	public String getMediaCreateUser() {
		return mediaCreateUser;
	}

	public void setMediaCreateUser(String mediaCreateUser) {
		this.mediaCreateUser = mediaCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMediaCreateTime() {
		return mediaCreateTime;
	}

	public void setMediaCreateTime(Date mediaCreateTime) {
		this.mediaCreateTime = mediaCreateTime;
	}
	
	@Length(min=0, max=40, message="记录更新人长度必须介于 0 和 40 之间")
	public String getMediaUpdateUser() {
		return mediaUpdateUser;
	}

	public void setMediaUpdateUser(String mediaUpdateUser) {
		this.mediaUpdateUser = mediaUpdateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMediaUpdateTime() {
		return mediaUpdateTime;
	}

	public void setMediaUpdateTime(Date mediaUpdateTime) {
		this.mediaUpdateTime = mediaUpdateTime;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getMediaIsDelete() {
		return mediaIsDelete;
	}

	public void setMediaIsDelete(String mediaIsDelete) {
		this.mediaIsDelete = mediaIsDelete;
	}
	
}