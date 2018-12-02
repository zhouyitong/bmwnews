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
import com.bmw.news.modules.news.entity.NActivityIamge;
import com.bmw.news.modules.news.service.NActivityIamgeService;

/**
 * 活动图片表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivityIamge")
public class NActivityIamgeController extends BaseController {

	@Autowired
	private NActivityIamgeService nActivityIamgeService;
	
	@ModelAttribute
	public NActivityIamge get(@RequestParam(required=false) String id) {
		NActivityIamge entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityIamgeService.get(id);
		}
		if (entity == null){
			entity = new NActivityIamge();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivityIamge:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivityIamge nActivityIamge, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivityIamge> page = nActivityIamgeService.findPage(new Page<NActivityIamge>(request, response), nActivityIamge); 
		model.addAttribute("page", page);
		return "modules/news/nActivityIamgeList";
	}

	@RequiresPermissions("news:nActivityIamge:view")
	@RequestMapping(value = "form")
	public String form(NActivityIamge nActivityIamge, Model model) {
		model.addAttribute("nActivityIamge", nActivityIamge);
		return "modules/news/nActivityIamgeForm";
	}

	@RequiresPermissions("news:nActivityIamge:edit")
	@RequestMapping(value = "save")
	public String save(NActivityIamge nActivityIamge, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivityIamge)){
			return form(nActivityIamge, model);
		}
		nActivityIamgeService.save(nActivityIamge);
		addMessage(redirectAttributes, "保存活动图片表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityIamge/?repage";
	}
	
	@RequiresPermissions("news:nActivityIamge:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivityIamge nActivityIamge, RedirectAttributes redirectAttributes) {
		nActivityIamgeService.delete(nActivityIamge);
		addMessage(redirectAttributes, "删除活动图片表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityIamge/?repage";
	}

}