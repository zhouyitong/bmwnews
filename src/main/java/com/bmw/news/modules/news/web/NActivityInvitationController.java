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
import com.bmw.news.modules.news.entity.NActivityInvitation;
import com.bmw.news.modules.news.service.NActivityInvitationService;

/**
 * 活动邀请函表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivityInvitation")
public class NActivityInvitationController extends BaseController {

	@Autowired
	private NActivityInvitationService nActivityInvitationService;
	
	@ModelAttribute
	public NActivityInvitation get(@RequestParam(required=false) String id) {
		NActivityInvitation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityInvitationService.get(id);
		}
		if (entity == null){
			entity = new NActivityInvitation();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivityInvitation:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivityInvitation nActivityInvitation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivityInvitation> page = nActivityInvitationService.findPage(new Page<NActivityInvitation>(request, response), nActivityInvitation); 
		model.addAttribute("page", page);
		return "modules/news/nActivityInvitationList";
	}

	@RequiresPermissions("news:nActivityInvitation:view")
	@RequestMapping(value = "form")
	public String form(NActivityInvitation nActivityInvitation, Model model) {
		model.addAttribute("nActivityInvitation", nActivityInvitation);
		return "modules/news/nActivityInvitationForm";
	}

	@RequiresPermissions("news:nActivityInvitation:edit")
	@RequestMapping(value = "save")
	public String save(NActivityInvitation nActivityInvitation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivityInvitation)){
			return form(nActivityInvitation, model);
		}
		nActivityInvitationService.save(nActivityInvitation);
		addMessage(redirectAttributes, "保存活动邀请函表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityInvitation/?repage";
	}
	
	@RequiresPermissions("news:nActivityInvitation:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivityInvitation nActivityInvitation, RedirectAttributes redirectAttributes) {
		nActivityInvitationService.delete(nActivityInvitation);
		addMessage(redirectAttributes, "删除活动邀请函表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityInvitation/?repage";
	}

}