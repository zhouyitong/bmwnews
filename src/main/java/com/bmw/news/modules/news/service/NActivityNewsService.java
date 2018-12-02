/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivityNews;
import com.bmw.news.modules.news.dao.NActivityNewsDao;

/**
 * 活动新闻稿表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityNewsService extends CrudService<NActivityNewsDao, NActivityNews> {

	public NActivityNews get(String id) {
		return super.get(id);
	}
	
	public List<NActivityNews> findList(NActivityNews nActivityNews) {
		return super.findList(nActivityNews);
	}
	
	public Page<NActivityNews> findPage(Page<NActivityNews> page, NActivityNews nActivityNews) {
		return super.findPage(page, nActivityNews);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivityNews nActivityNews) {
		super.save(nActivityNews);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivityNews nActivityNews) {
		super.delete(nActivityNews);
	}
	
}