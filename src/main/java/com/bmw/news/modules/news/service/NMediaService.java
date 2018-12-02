/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NMedia;
import com.bmw.news.modules.news.dao.NMediaDao;

/**
 * 媒体信息Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NMediaService extends CrudService<NMediaDao, NMedia> {

	public NMedia get(String id) {
		return super.get(id);
	}
	
	public List<NMedia> findList(NMedia nMedia) {
		return super.findList(nMedia);
	}
	
	public Page<NMedia> findPage(Page<NMedia> page, NMedia nMedia) {
		return super.findPage(page, nMedia);
	}
	
	@Transactional(readOnly = false)
	public void save(NMedia nMedia) {
		super.save(nMedia);
	}
	
	@Transactional(readOnly = false)
	public void delete(NMedia nMedia) {
		super.delete(nMedia);
	}
	
}