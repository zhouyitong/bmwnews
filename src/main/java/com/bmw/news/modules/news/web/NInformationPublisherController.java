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
import com.bmw.news.modules.news.entity.NInformationPublisher;
import com.bmw.news.modules.news.service.NInformationPublisherService;

/**
 * 资讯发布者表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nInformationPublisher")
public class NInformationPublisherController extends BaseController {

	@Autowired
	private NInformationPublisherService nInformationPublisherService;
	
	@ModelAttribute
	public NInformationPublisher get(@RequestParam(required=false) String id) {
		NInformationPublisher entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nInformationPublisherService.get(id);
		}
		if (entity == null){
			entity = new NInformationPublisher();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nInformationPublisher:view")
	@RequestMapping(value = {"list", ""})
	public String list(NInformationPublisher nInformationPublisher, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NInformationPublisher> page = nInformationPublisherService.findPage(new Page<NInformationPublisher>(request, response), nInformationPublisher); 
		model.addAttribute("page", page);
		return "modules/news/nInformationPublisherList";
	}

	@RequiresPermissions("news:nInformationPublisher:view")
	@RequestMapping(value = "form")
	public String form(NInformationPublisher nInformationPublisher, Model model) {
		model.addAttribute("nInformationPublisher", nInformationPublisher);
		return "modules/news/nInformationPublisherForm";
	}

	@RequiresPermissions("news:nInformationPublisher:edit")
	@RequestMapping(value = "save")
	public String save(NInformationPublisher nInformationPublisher, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nInformationPublisher)){
			return form(nInformationPublisher, model);
		}
		nInformationPublisherService.save(nInformationPublisher);
		addMessage(redirectAttributes, "保存资讯发布者表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nInformationPublisher/?repage";
	}
	
	@RequiresPermissions("news:nInformationPublisher:edit")
	@RequestMapping(value = "delete")
	public String delete(NInformationPublisher nInformationPublisher, RedirectAttributes redirectAttributes) {
		nInformationPublisherService.delete(nInformationPublisher);
		addMessage(redirectAttributes, "删除资讯发布者表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nInformationPublisher/?repage";
	}

}