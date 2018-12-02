/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NReporterInfo;
import com.bmw.news.modules.news.dao.NReporterInfoDao;

/**
 * 媒体记者信息Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NReporterInfoService extends CrudService<NReporterInfoDao, NReporterInfo> {

	public NReporterInfo get(String id) {
		return super.get(id);
	}
	
	public List<NReporterInfo> findList(NReporterInfo nReporterInfo) {
		return super.findList(nReporterInfo);
	}
	
	public Page<NReporterInfo> findPage(Page<NReporterInfo> page, NReporterInfo nReporterInfo) {
		return super.findPage(page, nReporterInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(NReporterInfo nReporterInfo) {
		super.save(nReporterInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(NReporterInfo nReporterInfo) {
		super.delete(nReporterInfo);
	}
	
}