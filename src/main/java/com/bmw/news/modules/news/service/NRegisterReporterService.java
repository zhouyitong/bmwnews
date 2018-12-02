/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NRegisterReporter;
import com.bmw.news.modules.news.dao.NRegisterReporterDao;

/**
 * 媒体记者注册Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NRegisterReporterService extends CrudService<NRegisterReporterDao, NRegisterReporter> {

	public NRegisterReporter get(String id) {
		return super.get(id);
	}
	
	public List<NRegisterReporter> findList(NRegisterReporter nRegisterReporter) {
		return super.findList(nRegisterReporter);
	}
	
	public Page<NRegisterReporter> findPage(Page<NRegisterReporter> page, NRegisterReporter nRegisterReporter) {
		return super.findPage(page, nRegisterReporter);
	}
	
	@Transactional(readOnly = false)
	public void save(NRegisterReporter nRegisterReporter) {
		super.save(nRegisterReporter);
	}
	
	@Transactional(readOnly = false)
	public void delete(NRegisterReporter nRegisterReporter) {
		super.delete(nRegisterReporter);
	}
	
}