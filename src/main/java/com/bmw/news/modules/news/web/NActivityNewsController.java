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
import com.bmw.news.modules.news.entity.NActivityNews;
import com.bmw.news.modules.news.service.NActivityNewsService;

/**
 * 活动新闻稿表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nActivityNews")
public class NActivityNewsController extends BaseController {

	@Autowired
	private NActivityNewsService nActivityNewsService;
	
	@ModelAttribute
	public NActivityNews get(@RequestParam(required=false) String id) {
		NActivityNews entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nActivityNewsService.get(id);
		}
		if (entity == null){
			entity = new NActivityNews();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nActivityNews:view")
	@RequestMapping(value = {"list", ""})
	public String list(NActivityNews nActivityNews, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NActivityNews> page = nActivityNewsService.findPage(new Page<NActivityNews>(request, response), nActivityNews); 
		model.addAttribute("page", page);
		return "modules/news/nActivityNewsList";
	}

	@RequiresPermissions("news:nActivityNews:view")
	@RequestMapping(value = "form")
	public String form(NActivityNews nActivityNews, Model model) {
		model.addAttribute("nActivityNews", nActivityNews);
		return "modules/news/nActivityNewsForm";
	}

	@RequiresPermissions("news:nActivityNews:edit")
	@RequestMapping(value = "save")
	public String save(NActivityNews nActivityNews, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nActivityNews)){
			return form(nActivityNews, model);
		}
		nActivityNewsService.save(nActivityNews);
		addMessage(redirectAttributes, "保存活动新闻稿表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityNews/?repage";
	}
	
	@RequiresPermissions("news:nActivityNews:edit")
	@RequestMapping(value = "delete")
	public String delete(NActivityNews nActivityNews, RedirectAttributes redirectAttributes) {
		nActivityNewsService.delete(nActivityNews);
		addMessage(redirectAttributes, "删除活动新闻稿表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nActivityNews/?repage";
	}

}