/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.dao;

import com.bmw.news.common.persistence.CrudDao;
import com.bmw.news.common.persistence.annotation.MyBatisDao;
import com.bmw.news.modules.news.entity.NActivityGroup;

/**
 * 活动分组表DAO接口
 * @author zyb
 * @version 2018-12-02
 */
@MyBatisDao
public interface NActivityGroupDao extends CrudDao<NActivityGroup> {
	
}