/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bmw.news.modules.news.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bmw.news.common.config.Global;
import com.bmw.news.common.persistence.Page;
import com.bmw.news.common.web.BaseController;
import com.bmw.news.common.utils.StringUtils;
import com.bmw.news.modules.news.entity.NActivityGroup;
import com.bmw.news.modules.news.service.NActivityGroupService;

/**
 * 活动分组表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivityGroup")
public class NActivityGroupController extends BaseController {

	@Autowired
	private NActivityGroupService nActivityGroupService;
	
	@ModelAttribute
	public NActivityGroup get(@RequestParam(required=false) String id) {
		NActivityGroup entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityGroupService.get(id);
		}
		if (entity == null){
			entity = new NActivityGroup();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivityGroup:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivityGroup nActivityGroup, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivityGroup> page = nActivityGroupService.findPage(new Page<NActivityGroup>(request, response), nActivityGroup); 
		model.addAttribute("page", page);
		return "modules/news/nActivityGroupList";
	}

	@RequiresPermissions("news:nActivityGroup:view")
	@RequestMapping(value = "form")
	public String form(NActivityGroup nActivityGroup, Model model) {
		model.addAttribute("nActivityGroup", nActivityGroup);
		return "modules/news/nActivityGroupForm";
	}

	@RequiresPermissions("news:nActivityGroup:edit")
	@RequestMapping(value = "save")
	public String save(NActivityGroup nActivityGroup, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivityGroup)){
			return form(nActivityGroup, model);
		}
		nActivityGroupService.save(nActivityGroup);
		addMessage(redirectAttributes, "保存活动分组表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityGroup/?repage";
	}
	
	@RequiresPermissions("news:nActivityGroup:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivityGroup nActivityGroup, RedirectAttributes redirectAttributes) {
		nActivityGroupService.delete(nActivityGroup);
		addMessage(redirectAttributes, "删除活动分组表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityGroup/?repage";
	}

}