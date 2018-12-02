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
import com.bmw.news.modules.news.entity.NActivityMedia;
import com.bmw.news.modules.news.service.NActivityMediaService;

/**
 * 活动邀请媒体表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivityMedia")
public class NActivityMediaController extends BaseController {

	@Autowired
	private NActivityMediaService nActivityMediaService;
	
	@ModelAttribute
	public NActivityMedia get(@RequestParam(required=false) String id) {
		NActivityMedia entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityMediaService.get(id);
		}
		if (entity == null){
			entity = new NActivityMedia();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivityMedia:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivityMedia nActivityMedia, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivityMedia> page = nActivityMediaService.findPage(new Page<NActivityMedia>(request, response), nActivityMedia); 
		model.addAttribute("page", page);
		return "modules/news/nActivityMediaList";
	}

	@RequiresPermissions("news:nActivityMedia:view")
	@RequestMapping(value = "form")
	public String form(NActivityMedia nActivityMedia, Model model) {
		model.addAttribute("nActivityMedia", nActivityMedia);
		return "modules/news/nActivityMediaForm";
	}

	@RequiresPermissions("news:nActivityMedia:edit")
	@RequestMapping(value = "save")
	public String save(NActivityMedia nActivityMedia, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivityMedia)){
			return form(nActivityMedia, model);
		}
		nActivityMediaService.save(nActivityMedia);
		addMessage(redirectAttributes, "保存活动邀请媒体表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityMedia/?repage";
	}
	
	@RequiresPermissions("news:nActivityMedia:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivityMedia nActivityMedia, RedirectAttributes redirectAttributes) {
		nActivityMediaService.delete(nActivityMedia);
		addMessage(redirectAttributes, "删除活动邀请媒体表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityMedia/?repage";
	}

}