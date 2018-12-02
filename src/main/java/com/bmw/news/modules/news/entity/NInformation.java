/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 资讯表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NInformation extends DataEntity<NInformation> {
	
	private static final long serialVersionUID = 1L;
	private String infoId;		// 资讯ID
	private String infoTitle;		// 资讯标题
	private String infoShowStyle;		// 资讯展示风格0大图1右侧小图2图集
	private String infoIndexImagePath;		// 资讯列表图片路径
	private String infoContent;		// 资讯正文
	private String infoIsTop;		// 是否置顶，0不置顶1置顶
	private String infoPublisher;		// 资讯发布者
	private String infoOwnChannel;		// 所属频道
	private Long infoShareNum;		// 资讯分享数量
	private Long infoLikeNum;		// 资讯点赞数量
	private Long infoDownloadNum;		// 资讯下载数量
	private String infoStatus;		// 0未审核1一审通过2二审通过
	private Date infoAuditTimeOne;		// 资讯一审通过时间
	private String infoAuditUserOne;		// 资讯一审审核人
	private Date infoAuditTimeTwo;		// 资讯二审通过时间
	private String infoAuditUserTwo;		// 资讯二审审核人
	private Date infoCreateTime;		// 资讯创建时间
	private String infoCreateUser;		// 资讯创建人
	private Date infoUpdateTime;		// 资讯更新时间
	private String infoUpdateUser;		// 资讯更新人
	private Long infoVersion;		// 资讯版本号
	private String infoIsDelete;		// 是否删除0未删除1删除
	
	public NInformation() {
		super();
	}

	public NInformation(String id){
		super(id);
	}

	@Length(min=1, max=40, message="资讯ID长度必须介于 1 和 40 之间")
	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	
	@Length(min=0, max=255, message="资讯标题长度必须介于 0 和 255 之间")
	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	
	@Length(min=0, max=1, message="资讯展示风格0大图1右侧小图2图集长度必须介于 0 和 1 之间")
	public String getInfoShowStyle() {
		return infoShowStyle;
	}

	public void setInfoShowStyle(String infoShowStyle) {
		this.infoShowStyle = infoShowStyle;
	}
	
	@Length(min=0, max=255, message="资讯列表图片路径长度必须介于 0 和 255 之间")
	public String getInfoIndexImagePath() {
		return infoIndexImagePath;
	}

	public void setInfoIndexImagePath(String infoIndexImagePath) {
		this.infoIndexImagePath = infoIndexImagePath;
	}
	
	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	
	@Length(min=0, max=1, message="是否置顶，0不置顶1置顶长度必须介于 0 和 1 之间")
	public String getInfoIsTop() {
		return infoIsTop;
	}

	public void setInfoIsTop(String infoIsTop) {
		this.infoIsTop = infoIsTop;
	}
	
	@Length(min=0, max=40, message="资讯发布者长度必须介于 0 和 40 之间")
	public String getInfoPublisher() {
		return infoPublisher;
	}

	public void setInfoPublisher(String infoPublisher) {
		this.infoPublisher = infoPublisher;
	}
	
	@Length(min=0, max=40, message="所属频道长度必须介于 0 和 40 之间")
	public String getInfoOwnChannel() {
		return infoOwnChannel;
	}

	public void setInfoOwnChannel(String infoOwnChannel) {
		this.infoOwnChannel = infoOwnChannel;
	}
	
	public Long getInfoShareNum() {
		return infoShareNum;
	}

	public void setInfoShareNum(Long infoShareNum) {
		this.infoShareNum = infoShareNum;
	}
	
	public Long getInfoLikeNum() {
		return infoLikeNum;
	}

	public void setInfoLikeNum(Long infoLikeNum) {
		this.infoLikeNum = infoLikeNum;
	}
	
	public Long getInfoDownloadNum() {
		return infoDownloadNum;
	}

	public void setInfoDownloadNum(Long infoDownloadNum) {
		this.infoDownloadNum = infoDownloadNum;
	}
	
	@Length(min=0, max=1, message="0未审核1一审通过2二审通过长度必须介于 0 和 1 之间")
	public String getInfoStatus() {
		return infoStatus;
	}

	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInfoAuditTimeOne() {
		return infoAuditTimeOne;
	}

	public void setInfoAuditTimeOne(Date infoAuditTimeOne) {
		this.infoAuditTimeOne = infoAuditTimeOne;
	}
	
	@Length(min=0, max=40, message="资讯一审审核人长度必须介于 0 和 40 之间")
	public String getInfoAuditUserOne() {
		return infoAuditUserOne;
	}

	public void setInfoAuditUserOne(String infoAuditUserOne) {
		this.infoAuditUserOne = infoAuditUserOne;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInfoAuditTimeTwo() {
		return infoAuditTimeTwo;
	}

	public void setInfoAuditTimeTwo(Date infoAuditTimeTwo) {
		this.infoAuditTimeTwo = infoAuditTimeTwo;
	}
	
	@Length(min=0, max=40, message="资讯二审审核人长度必须介于 0 和 40 之间")
	public String getInfoAuditUserTwo() {
		return infoAuditUserTwo;
	}

	public void setInfoAuditUserTwo(String infoAuditUserTwo) {
		this.infoAuditUserTwo = infoAuditUserTwo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInfoCreateTime() {
		return infoCreateTime;
	}

	public void setInfoCreateTime(Date infoCreateTime) {
		this.infoCreateTime = infoCreateTime;
	}
	
	@Length(min=0, max=40, message="资讯创建人长度必须介于 0 和 40 之间")
	public String getInfoCreateUser() {
		return infoCreateUser;
	}

	public void setInfoCreateUser(String infoCreateUser) {
		this.infoCreateUser = infoCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInfoUpdateTime() {
		return infoUpdateTime;
	}

	public void setInfoUpdateTime(Date infoUpdateTime) {
		this.infoUpdateTime = infoUpdateTime;
	}
	
	@Length(min=0, max=45, message="资讯更新人长度必须介于 0 和 45 之间")
	public String getInfoUpdateUser() {
		return infoUpdateUser;
	}

	public void setInfoUpdateUser(String infoUpdateUser) {
		this.infoUpdateUser = infoUpdateUser;
	}
	
	public Long getInfoVersion() {
		return infoVersion;
	}

	public void setInfoVersion(Long infoVersion) {
		this.infoVersion = infoVersion;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getInfoIsDelete() {
		return infoIsDelete;
	}

	public void setInfoIsDelete(String infoIsDelete) {
		this.infoIsDelete = infoIsDelete;
	}
	
}