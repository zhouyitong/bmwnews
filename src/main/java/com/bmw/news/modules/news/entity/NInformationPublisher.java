/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 资讯发布者表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NInformationPublisher extends DataEntity<NInformationPublisher> {
	
	private static final long serialVersionUID = 1L;
	private String publisherId;		// 资讯发布者主键
	private String publisherName;		// 发布者名字
	private Date publisherCreateTime;		// 发布者创建时间
	private String publisherCreateUser;		// 发布者创建人
	private String publisherPhotoImage;		// 发布者头像
	private Date publishUpdateTime;		// 发布者更新时间
	private String publisherUpdateUser;		// 发布者更新人
	private String publisherIsDelete;		// 是否删除0未删除1删除
	
	public NInformationPublisher() {
		super();
	}

	public NInformationPublisher(String id){
		super(id);
	}

	@Length(min=1, max=40, message="资讯发布者主键长度必须介于 1 和 40 之间")
	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	@Length(min=0, max=40, message="发布者名字长度必须介于 0 和 40 之间")
	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPublisherCreateTime() {
		return publisherCreateTime;
	}

	public void setPublisherCreateTime(Date publisherCreateTime) {
		this.publisherCreateTime = publisherCreateTime;
	}
	
	@Length(min=0, max=40, message="发布者创建人长度必须介于 0 和 40 之间")
	public String getPublisherCreateUser() {
		return publisherCreateUser;
	}

	public void setPublisherCreateUser(String publisherCreateUser) {
		this.publisherCreateUser = publisherCreateUser;
	}
	
	@Length(min=0, max=255, message="发布者头像长度必须介于 0 和 255 之间")
	public String getPublisherPhotoImage() {
		return publisherPhotoImage;
	}

	public void setPublisherPhotoImage(String publisherPhotoImage) {
		this.publisherPhotoImage = publisherPhotoImage;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPublishUpdateTime() {
		return publishUpdateTime;
	}

	public void setPublishUpdateTime(Date publishUpdateTime) {
		this.publishUpdateTime = publishUpdateTime;
	}
	
	@Length(min=0, max=40, message="发布者更新人长度必须介于 0 和 40 之间")
	public String getPublisherUpdateUser() {
		return publisherUpdateUser;
	}

	public void setPublisherUpdateUser(String publisherUpdateUser) {
		this.publisherUpdateUser = publisherUpdateUser;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getPublisherIsDelete() {
		return publisherIsDelete;
	}

	public void setPublisherIsDelete(String publisherIsDelete) {
		this.publisherIsDelete = publisherIsDelete;
	}
	
}