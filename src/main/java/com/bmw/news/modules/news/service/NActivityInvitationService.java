/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.service.CrudService;
import com.bmw.news.modules.news.entity.NActivityInvitation;
import com.bmw.news.modules.news.dao.NActivityInvitationDao;

/**
 * 活动邀请函表Service
 * @author zyb
 * @version 2018-12-02
 */
@Service
@Transactional(readOnly = true)
public class NActivityInvitationService extends CrudService<NActivityInvitationDao, NActivityInvitation> {

	public NActivityInvitation get(String id) {
		return super.get(id);
	}
	
	public List<NActivityInvitation> findList(NActivityInvitation nActivityInvitation) {
		return super.findList(nActivityInvitation);
	}
	
	public Page<NActivityInvitation> findPage(Page<NActivityInvitation> page, NActivityInvitation nActivityInvitation) {
		return super.findPage(page, nActivityInvitation);
	}
	
	@Transactional(readOnly = false)
	public void save(NActivityInvitation nActivityInvitation) {
		super.save(nActivityInvitation);
	}
	
	@Transactional(readOnly = false)
	public void delete(NActivityInvitation nActivityInvitation) {
		super.delete(nActivityInvitation);
	}
	
}