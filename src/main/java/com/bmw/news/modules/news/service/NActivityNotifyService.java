/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivityNotify;
import com.bmw.news.modules.news.dao.NActivityNotifyDao;

/**
 * 活动通知表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityNotifyService extends CrudService<NActivityNotifyDao, NActivityNotify> {

	public NActivityNotify get(String id) {
		return super.get(id);
	}
	
	public List<NActivityNotify> findList(NActivityNotify nActivityNotify) {
		return super.findList(nActivityNotify);
	}
	
	public Page<NActivityNotify> findPage(Page<NActivityNotify> page, NActivityNotify nActivityNotify) {
		return super.findPage(page, nActivityNotify);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivityNotify nActivityNotify) {
		super.save(nActivityNotify);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivityNotify nActivityNotify) {
		super.delete(nActivityNotify);
	}
	
}