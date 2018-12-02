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
import com.bmw.news.modules.news.entity.NInformationImage;
import com.bmw.news.modules.news.service.NInformationImageService;

/**
 * 资讯图片表Controller
 * @author zyb
 * @version 2018-12-02
 */
@Controller
@RequestMapping(value = "${adminPath}/news/nInformationImage")
public class NInformationImageController extends BaseController {

	@Autowired
	private NInformationImageService nInformationImageService;
	
	@ModelAttribute
	public NInformationImage get(@RequestParam(required=false) String id) {
		NInformationImage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = nInformationImageService.get(id);
		}
		if (entity == null){
			entity = new NInformationImage();
		}
		return entity;
	}
	
	@RequiresPermissions("news:nInformationImage:view")
	@RequestMapping(value = {"list", ""})
	public String list(NInformationImage nInformationImage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NInformationImage> page = nInformationImageService.findPage(new Page<NInformationImage>(request, response), nInformationImage); 
		model.addAttribute("page", page);
		return "modules/news/nInformationImageList";
	}

	@RequiresPermissions("news:nInformationImage:view")
	@RequestMapping(value = "form")
	public String form(NInformationImage nInformationImage, Model model) {
		model.addAttribute("nInformationImage", nInformationImage);
		return "modules/news/nInformationImageForm";
	}

	@RequiresPermissions("news:nInformationImage:edit")
	@RequestMapping(value = "save")
	public String save(NInformationImage nInformationImage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, nInformationImage)){
			return form(nInformationImage, model);
		}
		nInformationImageService.save(nInformationImage);
		addMessage(redirectAttributes, "保存资讯图片表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nInformationImage/?repage";
	}
	
	@RequiresPermissions("news:nInformationImage:edit")
	@RequestMapping(value = "delete")
	public String delete(NInformationImage nInformationImage, RedirectAttributes redirectAttributes) {
		nInformationImageService.delete(nInformationImage);
		addMessage(redirectAttributes, "删除资讯图片表成功");
		return "redirect:"+Global.getAdminPath()+"/news/nInformationImage/?repage";
	}

}