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
import com.bmw.news.modules.news.entity.NReporterInfo;
import com.bmw.news.modules.news.service.NReporterInfoService;

/**
 * 媒体记者信息Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nReporterInfo")
public class NReporterInfoController extends BaseController {

	@Autowired
	private NReporterInfoService nReporterInfoService;
	
	@ModelAttribute
	public NReporterInfo get(@RequestParam(required=false) String id) {
		NReporterInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nReporterInfoService.get(id);
		}
		if (entity == null){
			entity = new NReporterInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nReporterInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(NReporterInfo nReporterInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NReporterInfo> page = nReporterInfoService.findPage(new Page<NReporterInfo>(request, response), nReporterInfo); 
		model.addAttribute("page", page);
		return "modules/news/nReporterInfoList";
	}

	@RequiresPermissions("news:nReporterInfo:view")
	@RequestMapping(value = "form")
	public String form(NReporterInfo nReporterInfo, Model model) {
		model.addAttribute("nReporterInfo", nReporterInfo);
		return "modules/news/nReporterInfoForm";
	}

	@RequiresPermissions("news:nReporterInfo:edit")
	@RequestMapping(value = "save")
	public String save(NReporterInfo nReporterInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nReporterInfo)){
			return form(nReporterInfo, model);
		}
		nReporterInfoService.save(nReporterInfo);
		addMessage(redirectAttributes, "保存媒体记者信息成功");
		return "redirect:"+Global.getAdminPath()+"/news/nReporterInfo/?repage";
	}
	
	@RequiresPermissions("news:nReporterInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(NReporterInfo nReporterInfo, RedirectAttributes redirectAttributes) {
		nReporterInfoService.delete(nReporterInfo);
		addMessage(redirectAttributes, "删除媒体记者信息成功");
		return "redirect:"+Global.getAdminPath()+"/news/nReporterInfo/?repage";
	}

}