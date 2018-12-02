/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivityGroup;
import com.bmw.news.modules.news.dao.NActivityGroupDao;

/**
 * 活动分组表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityGroupService extends CrudService<NActivityGroupDao, NActivityGroup> {

	public NActivityGroup get(String id) {
		return super.get(id);
	}
	
	public List<NActivityGroup> findList(NActivityGroup nActivityGroup) {
		return super.findList(nActivityGroup);
	}
	
	public Page<NActivityGroup> findPage(Page<NActivityGroup> page, NActivityGroup nActivityGroup) {
		return super.findPage(page, nActivityGroup);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivityGroup nActivityGroup) {
		super.save(nActivityGroup);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivityGroup nActivityGroup) {
		super.delete(nActivityGroup);
	}
	
}