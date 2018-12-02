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
import com.bmw.news.modules.news.entity.NActivityNotify;
import com.bmw.news.modules.news.service.NActivityNotifyService;

/**
 * 活动通知表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivityNotify")
public class NActivityNotifyController extends BaseController {

	@Autowired
	private NActivityNotifyService nActivityNotifyService;
	
	@ModelAttribute
	public NActivityNotify get(@RequestParam(required=false) String id) {
		NActivityNotify entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityNotifyService.get(id);
		}
		if (entity == null){
			entity = new NActivityNotify();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivityNotify:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivityNotify nActivityNotify, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivityNotify> page = nActivityNotifyService.findPage(new Page<NActivityNotify>(request, response), nActivityNotify); 
		model.addAttribute("page", page);
		return "modules/news/nActivityNotifyList";
	}

	@RequiresPermissions("news:nActivityNotify:view")
	@RequestMapping(value = "form")
	public String form(NActivityNotify nActivityNotify, Model model) {
		model.addAttribute("nActivityNotify", nActivityNotify);
		return "modules/news/nActivityNotifyForm";
	}

	@RequiresPermissions("news:nActivityNotify:edit")
	@RequestMapping(value = "save")
	public String save(NActivityNotify nActivityNotify, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivityNotify)){
			return form(nActivityNotify, model);
		}
		nActivityNotifyService.save(nActivityNotify);
		addMessage(redirectAttributes, "保存活动通知表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityNotify/?repage";
	}
	
	@RequiresPermissions("news:nActivityNotify:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivityNotify nActivityNotify, RedirectAttributes redirectAttributes) {
		nActivityNotifyService.delete(nActivityNotify);
		addMessage(redirectAttributes, "删除活动通知表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityNotify/?repage";
	}

}