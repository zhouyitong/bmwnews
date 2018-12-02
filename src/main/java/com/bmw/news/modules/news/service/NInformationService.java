/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NInformation;
import com.bmw.news.modules.news.dao.NInformationDao;

/**
 * 资讯表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NInformationService extends CrudService<NInformationDao, NInformation> {

	public NInformation get(String id) {
		return super.get(id);
	}
	
	public List<NInformation> findList(NInformation nInformation) {
		return super.findList(nInformation);
	}
	
	public Page<NInformation> findPage(Page<NInformation> page, NInformation nInformation) {
		return super.findPage(page, nInformation);
	}
	
	@Transactional(readOnly = false)
	public void save(NInformation nInformation) {
		super.save(nInformation);
	}
	
	@Transactional(readOnly = false)
	public void delete(NInformation nInformation) {
		super.delete(nInformation);
	}
	
}