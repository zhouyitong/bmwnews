/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NInformationImage;
import com.bmw.news.modules.news.dao.NInformationImageDao;

/**
 * 资讯图片表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NInformationImageService extends CrudService<NInformationImageDao, NInformationImage> {

	public NInformationImage get(String id) {
		return super.get(id);
	}
	
	public List<NInformationImage> findList(NInformationImage nInformationImage) {
		return super.findList(nInformationImage);
	}
	
	public Page<NInformationImage> findPage(Page<NInformationImage> page, NInformationImage nInformationImage) {
		return super.findPage(page, nInformationImage);
	}
	
	@Transactional(readOnly = false)
	public void save(NInformationImage nInformationImage) {
		super.save(nInformationImage);
	}
	
	@Transactional(readOnly = false)
	public void delete(NInformationImage nInformationImage) {
		super.delete(nInformationImage);
	}
	
}