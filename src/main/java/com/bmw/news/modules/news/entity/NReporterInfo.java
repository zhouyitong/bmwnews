/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 媒体记者信息Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NReporterInfo extends DataEntity<NReporterInfo> {
	
	private static final long serialVersionUID = 1L;
	private String reporterId;		// 记者主键
	private String reporterName;		// 记者名字
	private String reporterOwnMedia;		// 所属媒体
	private String reporterOwnMediaName;		// 所属媒体名字
	private String reporterPhoneNum;		// 手机号码
	private String reporterTitle;		// 记者职位
	private Date reporterBirthday;		// 记者出生日期
	private String reporterClothesSize;		// 记者衣服尺码0XS1S2M3L4XL5XXL6XXXL
	private String reporterDrivingLicence;		// 记者驾龄
	private String reporterLevel;		// 记者级别1I2II3III4IV5V
	private String reporterEmail;		// 记者邮箱
	private String reporterZipCode;		// 邮政编码
	private String reporterGender;		// 记者性别0女1男
	private String reporterWorkTel;		// 工作座机
	private String reporterIdentityNum;		// 身份证号码
	private String reporterPassportNum;		// 媒体记者护照号码
	private String reporterHomeAddress;		// 家庭住址
	private String reporterIsHaveChild;		// 是否有孩子0无1有3不清楚
	private String reporterChildGender;		// 孩子性别0女孩1男孩
	private Date reporterChildBirthday;		// 孩子生日
	private String reporterSecondChildGender;		// 二孩性别0女孩1男孩
	private Date reporterSecondChildBirthday;		// 二孩生日
	private String reporterOtherInfo;		// 记者其他信息
	
	public NReporterInfo() {
		super();
	}

	public NReporterInfo(String id){
		super(id);
	}

	@Length(min=1, max=40, message="记者主键长度必须介于 1 和 40 之间")
	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}
	
	@Length(min=0, max=40, message="记者名字长度必须介于 0 和 40 之间")
	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	
	@Length(min=0, max=40, message="所属媒体长度必须介于 0 和 40 之间")
	public String getReporterOwnMedia() {
		return reporterOwnMedia;
	}

	public void setReporterOwnMedia(String reporterOwnMedia) {
		this.reporterOwnMedia = reporterOwnMedia;
	}
	
	@Length(min=0, max=255, message="所属媒体名字长度必须介于 0 和 255 之间")
	public String getReporterOwnMediaName() {
		return reporterOwnMediaName;
	}

	public void setReporterOwnMediaName(String reporterOwnMediaName) {
		this.reporterOwnMediaName = reporterOwnMediaName;
	}
	
	@Length(min=0, max=11, message="手机号码长度必须介于 0 和 11 之间")
	public String getReporterPhoneNum() {
		return reporterPhoneNum;
	}

	public void setReporterPhoneNum(String reporterPhoneNum) {
		this.reporterPhoneNum = reporterPhoneNum;
	}
	
	@Length(min=0, max=40, message="记者职位长度必须介于 0 和 40 之间")
	public String getReporterTitle() {
		return reporterTitle;
	}

	public void setReporterTitle(String reporterTitle) {
		this.reporterTitle = reporterTitle;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterBirthday() {
		return reporterBirthday;
	}

	public void setReporterBirthday(Date reporterBirthday) {
		this.reporterBirthday = reporterBirthday;
	}
	
	@Length(min=0, max=1, message="记者衣服尺码0XS1S2M3L4XL5XXL6XXXL长度必须介于 0 和 1 之间")
	public String getReporterClothesSize() {
		return reporterClothesSize;
	}

	public void setReporterClothesSize(String reporterClothesSize) {
		this.reporterClothesSize = reporterClothesSize;
	}
	
	@Length(min=0, max=11, message="记者驾龄长度必须介于 0 和 11 之间")
	public String getReporterDrivingLicence() {
		return reporterDrivingLicence;
	}

	public void setReporterDrivingLicence(String reporterDrivingLicence) {
		this.reporterDrivingLicence = reporterDrivingLicence;
	}
	
	@Length(min=0, max=1, message="记者级别1I2II3III4IV5V长度必须介于 0 和 1 之间")
	public String getReporterLevel() {
		return reporterLevel;
	}

	public void setReporterLevel(String reporterLevel) {
		this.reporterLevel = reporterLevel;
	}
	
	@Length(min=0, max=255, message="记者邮箱长度必须介于 0 和 255 之间")
	public String getReporterEmail() {
		return reporterEmail;
	}

	public void setReporterEmail(String reporterEmail) {
		this.reporterEmail = reporterEmail;
	}
	
	@Length(min=0, max=6, message="邮政编码长度必须介于 0 和 6 之间")
	public String getReporterZipCode() {
		return reporterZipCode;
	}

	public void setReporterZipCode(String reporterZipCode) {
		this.reporterZipCode = reporterZipCode;
	}
	
	@Length(min=0, max=1, message="记者性别0女1男长度必须介于 0 和 1 之间")
	public String getReporterGender() {
		return reporterGender;
	}

	public void setReporterGender(String reporterGender) {
		this.reporterGender = reporterGender;
	}
	
	@Length(min=0, max=40, message="工作座机长度必须介于 0 和 40 之间")
	public String getReporterWorkTel() {
		return reporterWorkTel;
	}

	public void setReporterWorkTel(String reporterWorkTel) {
		this.reporterWorkTel = reporterWorkTel;
	}
	
	@Length(min=0, max=18, message="身份证号码长度必须介于 0 和 18 之间")
	public String getReporterIdentityNum() {
		return reporterIdentityNum;
	}

	public void setReporterIdentityNum(String reporterIdentityNum) {
		this.reporterIdentityNum = reporterIdentityNum;
	}
	
	@Length(min=0, max=11, message="媒体记者护照号码长度必须介于 0 和 11 之间")
	public String getReporterPassportNum() {
		return reporterPassportNum;
	}

	public void setReporterPassportNum(String reporterPassportNum) {
		this.reporterPassportNum = reporterPassportNum;
	}
	
	@Length(min=0, max=255, message="家庭住址长度必须介于 0 和 255 之间")
	public String getReporterHomeAddress() {
		return reporterHomeAddress;
	}

	public void setReporterHomeAddress(String reporterHomeAddress) {
		this.reporterHomeAddress = reporterHomeAddress;
	}
	
	@Length(min=0, max=1, message="是否有孩子0无1有3不清楚长度必须介于 0 和 1 之间")
	public String getReporterIsHaveChild() {
		return reporterIsHaveChild;
	}

	public void setReporterIsHaveChild(String reporterIsHaveChild) {
		this.reporterIsHaveChild = reporterIsHaveChild;
	}
	
	@Length(min=0, max=1, message="孩子性别0女孩1男孩长度必须介于 0 和 1 之间")
	public String getReporterChildGender() {
		return reporterChildGender;
	}

	public void setReporterChildGender(String reporterChildGender) {
		this.reporterChildGender = reporterChildGender;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterChildBirthday() {
		return reporterChildBirthday;
	}

	public void setReporterChildBirthday(Date reporterChildBirthday) {
		this.reporterChildBirthday = reporterChildBirthday;
	}
	
	@Length(min=0, max=1, message="二孩性别0女孩1男孩长度必须介于 0 和 1 之间")
	public String getReporterSecondChildGender() {
		return reporterSecondChildGender;
	}

	public void setReporterSecondChildGender(String reporterSecondChildGender) {
		this.reporterSecondChildGender = reporterSecondChildGender;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReporterSecondChildBirthday() {
		return reporterSecondChildBirthday;
	}

	public void setReporterSecondChildBirthday(Date reporterSecondChildBirthday) {
		this.reporterSecondChildBirthday = reporterSecondChildBirthday;
	}
	
	@Length(min=0, max=400, message="记者其他信息长度必须介于 0 和 400 之间")
	public String getReporterOtherInfo() {
		return reporterOtherInfo;
	}

	public void setReporterOtherInfo(String reporterOtherInfo) {
		this.reporterOtherInfo = reporterOtherInfo;
	}
	
}