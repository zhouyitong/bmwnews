/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NNewsBulletin;
import com.bmw.news.modules.news.dao.NNewsBulletinDao;

/**
 * 新闻简报表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NNewsBulletinService extends CrudService<NNewsBulletinDao, NNewsBulletin> {

	public NNewsBulletin get(String id) {
		return super.get(id);
	}
	
	public List<NNewsBulletin> findList(NNewsBulletin nNewsBulletin) {
		return super.findList(nNewsBulletin);
	}
	
	public Page<NNewsBulletin> findPage(Page<NNewsBulletin> page, NNewsBulletin nNewsBulletin) {
		return super.findPage(page, nNewsBulletin);
	}
	
	@Transactional(readOnly = false)
	public void save(NNewsBulletin nNewsBulletin) {
		super.save(nNewsBulletin);
	}
	
	@Transactional(readOnly = false)
	public void delete(NNewsBulletin nNewsBulletin) {
		super.delete(nNewsBulletin);
	}
	
}