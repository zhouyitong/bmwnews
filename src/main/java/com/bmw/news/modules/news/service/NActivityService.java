/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivity;
import com.bmw.news.modules.news.dao.NActivityDao;

/**
 * 活动表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityService extends CrudService<NActivityDao, NActivity> {

	public NActivity get(String id) {
		return super.get(id);
	}
	
	public List<NActivity> findList(NActivity nActivity) {
		return super.findList(nActivity);
	}
	
	public Page<NActivity> findPage(Page<NActivity> page, NActivity nActivity) {
		return super.findPage(page, nActivity);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivity nActivity) {
		super.save(nActivity);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivity nActivity) {
		super.delete(nActivity);
	}
	
}