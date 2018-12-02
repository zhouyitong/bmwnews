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
import com.bmw.news.modules.news.entity.NActivity;
import com.bmw.news.modules.news.service.NActivityService;

/**
 * 活动表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivity")
public class NActivityController extends BaseController {

	@Autowired
	private NActivityService nActivityService;
	
	@ModelAttribute
	public NActivity get(@RequestParam(required=false) String id) {
		NActivity entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityService.get(id);
		}
		if (entity == null){
			entity = new NActivity();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivity:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivity nActivity, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivity> page = nActivityService.findPage(new Page<NActivity>(request, response), nActivity); 
		model.addAttribute("page", page);
		return "modules/news/nActivityList";
	}

	@RequiresPermissions("news:nActivity:view")
	@RequestMapping(value = "form")
	public String form(NActivity nActivity, Model model) {
		model.addAttribute("nActivity", nActivity);
		return "modules/news/nActivityForm";
	}

	@RequiresPermissions("news:nActivity:edit")
	@RequestMapping(value = "save")
	public String save(NActivity nActivity, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivity)){
			return form(nActivity, model);
		}
		nActivityService.save(nActivity);
		addMessage(redirectAttributes, "保存活动表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivity/?repage";
	}
	
	@RequiresPermissions("news:nActivity:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivity nActivity, RedirectAttributes redirectAttributes) {
		nActivityService.delete(nActivity);
		addMessage(redirectAttributes, "删除活动表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivity/?repage";
	}

}