package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IModuleService;
import com.shop.manage.domain.Module;
import com.shop.manage.dto.ModuleDTO;
import java.util.Map;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 系统模块控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
public class ModuleController extends BaseController {

    @Autowired
    private IModuleService moduleService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,ModuleDTO moduleDTO) {
		PageInfo<ModuleDTO> splitPage = moduleService.findSplitPage(moduleDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("moduleDTO", moduleDTO);
		return "admin/module/main";
	}
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, ModuleDTO moduleDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		moduleService.insertModule(moduleDTO);
		map.put("success",true);
		return map;
	}

}