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
import com.bmw.news.modules.news.entity.NInformation;
import com.bmw.news.modules.news.service.NInformationService;

/**
 * 资讯表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nInformation")
public class NInformationController extends BaseController {

	@Autowired
	private NInformationService nInformationService;
	
	@ModelAttribute
	public NInformation get(@RequestParam(required=false) String id) {
		NInformation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nInformationService.get(id);
		}
		if (entity == null){
			entity = new NInformation();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nInformation:view")
	@RequestMapping(value = {"list", ""})
	public String list(NInformation nInformation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NInformation> page = nInformationService.findPage(new Page<NInformation>(request, response), nInformation); 
		model.addAttribute("page", page);
		return "modules/news/nInformationList";
	}

	@RequiresPermissions("news:nInformation:view")
	@RequestMapping(value = "form")
	public String form(NInformation nInformation, Model model) {
		model.addAttribute("nInformation", nInformation);
		return "modules/news/nInformationForm";
	}

	@RequiresPermissions("news:nInformation:edit")
	@RequestMapping(value = "save")
	public String save(NInformation nInformation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nInformation)){
			return form(nInformation, model);
		}
		nInformationService.save(nInformation);
		addMessage(redirectAttributes, "保存资讯表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nInformation/?repage";
	}
	
	@RequiresPermissions("news:nInformation:edit")
	@RequestMapping(value = "delete")
	public String delete(NInformation nInformation, RedirectAttributes redirectAttributes) {
		nInformationService.delete(nInformation);
		addMessage(redirectAttributes, "删除资讯表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nInformation/?repage";
	}

}