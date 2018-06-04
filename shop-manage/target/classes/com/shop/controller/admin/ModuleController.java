package com.shop.controller.admin;

import java.util.HashMap;
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
import com.shop.dto.admin.ModuleDTO;
import com.shop.service.admin.IModuleService;
import com.shop.web.BaseController;

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


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,ModuleDTO moduleDTO) {
		PageInfo<Module> splitPage = moduleService.findSplitPage(moduleDTO);
		model.addAttribute("moduleSplitPages", splitPage);
		model.addAttribute("moduleDto", moduleDTO);
		return "admin/module/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, ModuleDTO moduleDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		moduleService.insertModule(moduleDTO);
		map.put("success",true);
		return map;
	}

}