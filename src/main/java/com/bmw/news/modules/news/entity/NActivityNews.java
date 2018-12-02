/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.bmw.news.common.persistence.DataEntity;

/**
 * 活动新闻稿表Entity
 * @author zyb
 * @version 2018-12-02
 */
public class NActivityNews extends DataEntity<NActivityNews> {
	
	private static final long serialVersionUID = 1L;
	private String newsId;		// 新闻稿ID
	private String activityId;		// 活动ID
	private String newsTitle;		// 新闻稿标题
	private String newsContent;		// 新闻稿内容
	private Date newsCreateTime;		// 新闻稿创建时间
	private String newsCreateUser;		// 新闻稿创建用户
	private Date newsUpdateTime;		// 新闻稿更新时间
	private String newsUpdateUser;		// 新闻稿更新用户
	private String newsIsAudit;		// 新闻稿是否审核0未审核1一审2二审
	private String newsAuditUserOne;		// 新闻稿一审用户
	private Date newsAuditTimeOne;		// 新闻稿一审时间
	private String newsAuditUserTwo;		// 新闻稿二审用户
	private Date newsAuditTimeTwo;		// 新闻稿二审时间
	private String newsIsCrontab;		// 是否定时发送0不定时1定时
	private Date newsCronTime;		// 定时发送时间
	private String newsIsDelete;		// 是否删除0未删除1删除
	private Long newsLikeNum;		// 新闻稿点赞数量
	private Long newsShareNum;		// 新闻稿分享数量
	private Long newsDownloadNum;		// 新闻稿下载数量
	private Long newsVersion;		// 新闻稿版本
	
	public NActivityNews() {
		super();
	}

	public NActivityNews(String id){
		super(id);
	}

	@Length(min=1, max=40, message="新闻稿ID长度必须介于 1 和 40 之间")
	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	
	@Length(min=0, max=40, message="活动ID长度必须介于 0 和 40 之间")
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	@Length(min=0, max=255, message="新闻稿标题长度必须介于 0 和 255 之间")
	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	
	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNewsCreateTime() {
		return newsCreateTime;
	}

	public void setNewsCreateTime(Date newsCreateTime) {
		this.newsCreateTime = newsCreateTime;
	}
	
	@Length(min=0, max=40, message="新闻稿创建用户长度必须介于 0 和 40 之间")
	public String getNewsCreateUser() {
		return newsCreateUser;
	}

	public void setNewsCreateUser(String newsCreateUser) {
		this.newsCreateUser = newsCreateUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNewsUpdateTime() {
		return newsUpdateTime;
	}

	public void setNewsUpdateTime(Date newsUpdateTime) {
		this.newsUpdateTime = newsUpdateTime;
	}
	
	@Length(min=0, max=40, message="新闻稿更新用户长度必须介于 0 和 40 之间")
	public String getNewsUpdateUser() {
		return newsUpdateUser;
	}

	public void setNewsUpdateUser(String newsUpdateUser) {
		this.newsUpdateUser = newsUpdateUser;
	}
	
	@Length(min=0, max=1, message="新闻稿是否审核0未审核1一审2二审长度必须介于 0 和 1 之间")
	public String getNewsIsAudit() {
		return newsIsAudit;
	}

	public void setNewsIsAudit(String newsIsAudit) {
		this.newsIsAudit = newsIsAudit;
	}
	
	@Length(min=0, max=40, message="新闻稿一审用户长度必须介于 0 和 40 之间")
	public String getNewsAuditUserOne() {
		return newsAuditUserOne;
	}

	public void setNewsAuditUserOne(String newsAuditUserOne) {
		this.newsAuditUserOne = newsAuditUserOne;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNewsAuditTimeOne() {
		return newsAuditTimeOne;
	}

	public void setNewsAuditTimeOne(Date newsAuditTimeOne) {
		this.newsAuditTimeOne = newsAuditTimeOne;
	}
	
	@Length(min=0, max=40, message="新闻稿二审用户长度必须介于 0 和 40 之间")
	public String getNewsAuditUserTwo() {
		return newsAuditUserTwo;
	}

	public void setNewsAuditUserTwo(String newsAuditUserTwo) {
		this.newsAuditUserTwo = newsAuditUserTwo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNewsAuditTimeTwo() {
		return newsAuditTimeTwo;
	}

	public void setNewsAuditTimeTwo(Date newsAuditTimeTwo) {
		this.newsAuditTimeTwo = newsAuditTimeTwo;
	}
	
	@Length(min=0, max=1, message="是否定时发送0不定时1定时长度必须介于 0 和 1 之间")
	public String getNewsIsCrontab() {
		return newsIsCrontab;
	}

	public void setNewsIsCrontab(String newsIsCrontab) {
		this.newsIsCrontab = newsIsCrontab;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getNewsCronTime() {
		return newsCronTime;
	}

	public void setNewsCronTime(Date newsCronTime) {
		this.newsCronTime = newsCronTime;
	}
	
	@Length(min=0, max=1, message="是否删除0未删除1删除长度必须介于 0 和 1 之间")
	public String getNewsIsDelete() {
		return newsIsDelete;
	}

	public void setNewsIsDelete(String newsIsDelete) {
		this.newsIsDelete = newsIsDelete;
	}
	
	public Long getNewsLikeNum() {
		return newsLikeNum;
	}

	public void setNewsLikeNum(Long newsLikeNum) {
		this.newsLikeNum = newsLikeNum;
	}
	
	public Long getNewsShareNum() {
		return newsShareNum;
	}

	public void setNewsShareNum(Long newsShareNum) {
		this.newsShareNum = newsShareNum;
	}
	
	public Long getNewsDownloadNum() {
		return newsDownloadNum;
	}

	public void setNewsDownloadNum(Long newsDownloadNum) {
		this.newsDownloadNum = newsDownloadNum;
	}
	
	public Long getNewsVersion() {
		return newsVersion;
	}

	public void setNewsVersion(Long newsVersion) {
		this.newsVersion = newsVersion;
	}
	
}