package com.shop.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.shop.dto.admin.ResourceDTO;
import com.shop.service.admin.IModuleService;
import com.shop.service.admin.IResourceService;
import com.shop.web.BaseController;

/**
 * @date 20180602
 * @author 张林
 * @description 系统资源控制层
 * @gitHub:https://github.com/lzdn
 */
@Controller
@RequestMapping(value = "resource")
public class ResourceController extends BaseController {

	@Autowired
	private IModuleService moduleService;

	@Autowired
	private IResourceService resourceService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model, ResourceDTO resourceDTO) {
		PageInfo<Resource> splitPage = resourceService.findSplitPage(resourceDTO);
		model.addAttribute("resourceSplitPages", splitPage);
		model.addAttribute("resourceDto", resourceDTO);
		model.addAttribute("resources", resourceService.findAll(null));
		List<Module> modules = moduleService.findAll(null);
		model.addAttribute("modules", modules);
		return "admin/resource/main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, ResourceDTO resourceDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		resourceService.insertResource(resourceDTO);
		map.put("success", true);
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, Integer id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		resourceService.deleteByPk(id);
		map.put("success", true);
		return map;
	}

}