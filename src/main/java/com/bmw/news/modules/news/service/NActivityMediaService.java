/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivityMedia;
import com.bmw.news.modules.news.dao.NActivityMediaDao;

/**
 * 活动邀请媒体表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityMediaService extends CrudService<NActivityMediaDao, NActivityMedia> {

	public NActivityMedia get(String id) {
		return super.get(id);
	}
	
	public List<NActivityMedia> findList(NActivityMedia nActivityMedia) {
		return super.findList(nActivityMedia);
	}
	
	public Page<NActivityMedia> findPage(Page<NActivityMedia> page, NActivityMedia nActivityMedia) {
		return super.findPage(page, nActivityMedia);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivityMedia nActivityMedia) {
		super.save(nActivityMedia);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivityMedia nActivityMedia) {
		super.delete(nActivityMedia);
	}
	
}