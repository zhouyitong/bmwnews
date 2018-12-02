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
import com.bmw.news.modules.news.entity.NRegisterReporter;
import com.bmw.news.modules.news.service.NRegisterReporterService;

/**
 * 媒体记者注册Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nRegisterReporter")
public class NRegisterReporterController extends BaseController {

	@Autowired
	private NRegisterReporterService nRegisterReporterService;
	
	@ModelAttribute
	public NRegisterReporter get(@RequestParam(required=false) String id) {
		NRegisterReporter entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nRegisterReporterService.get(id);
		}
		if (entity == null){
			entity = new NRegisterReporter();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nRegisterReporter:view")
	@RequestMapping(value = {"list", ""})
	public String list(NRegisterReporter nRegisterReporter, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NRegisterReporter> page = nRegisterReporterService.findPage(new Page<NRegisterReporter>(request, response), nRegisterReporter); 
		model.addAttribute("page", page);
		return "modules/news/nRegisterReporterList";
	}

	@RequiresPermissions("news:nRegisterReporter:view")
	@RequestMapping(value = "form")
	public String form(NRegisterReporter nRegisterReporter, Model model) {
		model.addAttribute("nRegisterReporter", nRegisterReporter);
		return "modules/news/nRegisterReporterForm";
	}

	@RequiresPermissions("news:nRegisterReporter:edit")
	@RequestMapping(value = "save")
	public String save(NRegisterReporter nRegisterReporter, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nRegisterReporter)){
			return form(nRegisterReporter, model);
		}
		nRegisterReporterService.save(nRegisterReporter);
		addMessage(redirectAttributes, "保存媒体记者注册成功");
		return "redirect:"+Global.getAdminPath()+"/news/nRegisterReporter/?repage";
	}
	
	@RequiresPermissions("news:nRegisterReporter:edit")
	@RequestMapping(value = "delete")
	public String delete(NRegisterReporter nRegisterReporter, RedirectAttributes redirectAttributes) {
		nRegisterReporterService.delete(nRegisterReporter);
		addMessage(redirectAttributes, "删除媒体记者注册成功");
		return "redirect:"+Global.getAdminPath()+"/news/nRegisterReporter/?repage";
	}

}