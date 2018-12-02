/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 资讯图片表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NInformationImage extends DataEntity<NInformationImage> {
	
	private static final long serialVersionUID = 1L;
	private String imageId;		// 图片ID
	private String publisherId;		// 资讯发布者主键
	private String imageFilePath;		// 图片文件路径
	private Date imageUploadTime;		// 资讯正文图片上传时间
	private String imageUploadUser;		// 资讯正文图片上传人
	
	public NInformationImage() {
		super();
	}

	public NInformationImage(String id){
		super(id);
	}

	@Length(min=1, max=40, message="图片ID长度必须介于 1 和 40 之间")
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	@Length(min=0, max=40, message="资讯发布者主键长度必须介于 0 和 40 之间")
	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	@Length(min=0, max=255, message="图片文件路径长度必须介于 0 和 255 之间")
	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getImageUploadTime() {
		return imageUploadTime;
	}

	public void setImageUploadTime(Date imageUploadTime) {
		this.imageUploadTime = imageUploadTime;
	}
	
	@Length(min=0, max=40, message="资讯正文图片上传人长度必须介于 0 和 40 之间")
	public String getImageUploadUser() {
		return imageUploadUser;
	}

	public void setImageUploadUser(String imageUploadUser) {
		this.imageUploadUser = imageUploadUser;
	}
	
}