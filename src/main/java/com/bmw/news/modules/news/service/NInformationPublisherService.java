/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NInformationPublisher;
import com.bmw.news.modules.news.dao.NInformationPublisherDao;

/**
 * 资讯发布者表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NInformationPublisherService extends CrudService<NInformationPublisherDao, NInformationPublisher> {

	public NInformationPublisher get(String id) {
		return super.get(id);
	}
	
	public List<NInformationPublisher> findList(NInformationPublisher nInformationPublisher) {
		return super.findList(nInformationPublisher);
	}
	
	public Page<NInformationPublisher> findPage(Page<NInformationPublisher> page, NInformationPublisher nInformationPublisher) {
		return super.findPage(page, nInformationPublisher);
	}
	
	@Transactional(readOnly = false)
	public void save(NInformationPublisher nInformationPublisher) {
		super.save(nInformationPublisher);
	}
	
	@Transactional(readOnly = false)
	public void delete(NInformationPublisher nInformationPublisher) {
		super.delete(nInformationPublisher);
	}
	
}