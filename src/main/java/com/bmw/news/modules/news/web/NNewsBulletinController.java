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
import com.bmw.news.modules.news.entity.NNewsBulletin;
import com.bmw.news.modules.news.service.NNewsBulletinService;

/**
 * 新闻简报表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nNewsBulletin")
public class NNewsBulletinController extends BaseController {

	@Autowired
	private NNewsBulletinService nNewsBulletinService;
	
	@ModelAttribute
	public NNewsBulletin get(@RequestParam(required=false) String id) {
		NNewsBulletin entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nNewsBulletinService.get(id);
		}
		if (entity == null){
			entity = new NNewsBulletin();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nNewsBulletin:view")
	@RequestMapping(value = {"list", ""})
	public String list(NNewsBulletin nNewsBulletin, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NNewsBulletin> page = nNewsBulletinService.findPage(new Page<NNewsBulletin>(request, response), nNewsBulletin); 
		model.addAttribute("page", page);
		return "modules/news/nNewsBulletinList";
	}

	@RequiresPermissions("news:nNewsBulletin:view")
	@RequestMapping(value = "form")
	public String form(NNewsBulletin nNewsBulletin, Model model) {
		model.addAttribute("nNewsBulletin", nNewsBulletin);
		return "modules/news/nNewsBulletinForm";
	}

	@RequiresPermissions("news:nNewsBulletin:edit")
	@RequestMapping(value = "save")
	public String save(NNewsBulletin nNewsBulletin, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nNewsBulletin)){
			return form(nNewsBulletin, model);
		}
		nNewsBulletinService.save(nNewsBulletin);
		addMessage(redirectAttributes, "保存新闻简报表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nNewsBulletin/?repage";
	}
	
	@RequiresPermissions("news:nNewsBulletin:edit")
	@RequestMapping(value = "delete")
	public String delete(NNewsBulletin nNewsBulletin, RedirectAttributes redirectAttributes) {
		nNewsBulletinService.delete(nNewsBulletin);
		addMessage(redirectAttributes, "删除新闻简报表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nNewsBulletin/?repage";
	}

}