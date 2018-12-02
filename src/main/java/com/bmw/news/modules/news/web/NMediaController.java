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
import com.bmw.news.modules.news.entity.NMedia;
import com.bmw.news.modules.news.service.NMediaService;

/**
 * 媒体信息Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nMedia")
public class NMediaController extends BaseController {

	@Autowired
	private NMediaService nMediaService;
	
	@ModelAttribute
	public NMedia get(@RequestParam(required=false) String id) {
		NMedia entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nMediaService.get(id);
		}
		if (entity == null){
			entity = new NMedia();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nMedia:view")
	@RequestMapping(value = {"list", ""})
	public String list(NMedia nMedia, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NMedia> page = nMediaService.findPage(new Page<NMedia>(request, response), nMedia); 
		model.addAttribute("page", page);
		return "modules/news/nMediaList";
	}

	@RequiresPermissions("news:nMedia:view")
	@RequestMapping(value = "form")
	public String form(NMedia nMedia, Model model) {
		model.addAttribute("nMedia", nMedia);
		return "modules/news/nMediaForm";
	}

	@RequiresPermissions("news:nMedia:edit")
	@RequestMapping(value = "save")
	public String save(NMedia nMedia, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nMedia)){
			return form(nMedia, model);
		}
		nMediaService.save(nMedia);
		addMessage(redirectAttributes, "保存媒体信息成功");
		return "redirect:"+Global.getAdminPath()+"/news/nMedia/?repage";
	}
	
	@RequiresPermissions("news:nMedia:edit")
	@RequestMapping(value = "delete")
	public String delete(NMedia nMedia, RedirectAttributes redirectAttributes) {
		nMediaService.delete(nMedia);
		addMessage(redirectAttributes, "删除媒体信息成功");
		return "redirect:"+Global.getAdminPath()+"/news/nMedia/?repage";
	}

}