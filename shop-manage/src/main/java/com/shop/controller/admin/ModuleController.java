package com.shop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Module;
import com.shop.domain.admin.Resource;
import com.shop.dto.admin.ModuleDTO;
import com.shop.dto.admin.ResourceDTO;
import com.shop.service.admin.IModuleService;
import com.shop.service.admin.IResourceService;
import com.shop.web.BaseController;
import com.shop.web.Result;

/**
 * @date 20180602
 * @author 张林
 * @description 系统模块控制层
 * @gitHub:https://github.com/lzdn
 */
@Controller
@RequestMapping(value = "module")
public class ModuleController extends BaseController {

	@Autowired
	private IModuleService moduleService;

	@Autowired
	private IResourceService resourceService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model, ModuleDTO moduleDTO) {
		PageInfo<Module> splitPage = moduleService.findSplitPage(moduleDTO);
		model.addAttribute("moduleSplitPages", splitPage);
		model.addAttribute("moduleDto", moduleDTO);
		return "admin/module/main";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Result save(HttpServletRequest request, ModuleDTO moduleDTO) throws Exception {
		if(moduleDTO.getModuleId()!=null) {
			moduleService.updateModule(moduleDTO);
		}else {
			moduleService.insertModule(moduleDTO);
		}
		return new Result(SUCCESS);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result delete(HttpServletRequest request, Integer moduleId) throws Exception {
		moduleService.deleteByPk(moduleId);
		return new Result(SUCCESS);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletResponse response, Model model, Integer moduleId) {
		Module dto = moduleService.findByPk(moduleId);
		if(dto == null) {
			model.addAttribute("message", "不存在：["+moduleId+"]");
			return "admin/common/notice";
		}
		model.addAttribute("module", dto);
		return "admin/module/edit";
	}
	
	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resource(HttpServletResponse response, Model model, Integer moduleId) {
		ResourceDTO resourceDTO = new ResourceDTO();
		resourceDTO.setModuleId(moduleId);
		resourceDTO.setParentId(0);
		PageInfo<Resource> splitPage = resourceService.findSplitPage(resourceDTO);
		model.addAttribute("resourceSplitPages", splitPage);
		model.addAttribute("resourceDto", resourceDTO);
		model.addAttribute("resources", resourceService.findAll(null));
		return "admin/resource/stage";
	}

}