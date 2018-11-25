/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xywy.zngj.modules.sys.dao;

import com.xywy.zngj.common.persistence.TreeDao;
import com.xywy.zngj.common.persistence.annotation.MyBatisDao;
import com.xywy.zngj.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
