/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivityIamge;
import com.bmw.news.modules.news.dao.NActivityIamgeDao;

/**
 * 活动图片表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityIamgeService extends CrudService<NActivityIamgeDao, NActivityIamge> {

	public NActivityIamge get(String id) {
		return super.get(id);
	}
	
	public List<NActivityIamge> findList(NActivityIamge nActivityIamge) {
		return super.findList(nActivityIamge);
	}
	
	public Page<NActivityIamge> findPage(Page<NActivityIamge> page, NActivityIamge nActivityIamge) {
		return super.findPage(page, nActivityIamge);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivityIamge nActivityIamge) {
		super.save(nActivityIamge);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivityIamge nActivityIamge) {
		super.delete(nActivityIamge);
	}
	
}