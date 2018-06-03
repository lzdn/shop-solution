package com.shop.controller.admin;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.shop.web.BaseController;

import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import com.shop.service.admin.IModuleService;
import com.shop.service.admin.IRoleService;
import com.shop.dto.admin.ModuleDTO;
import com.shop.dto.admin.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 20180602
 * @author 张林
 * @description 角色控制层
 * @gitHub:https://github.com/lzdn
 */
@Controller
@RequestMapping(value = "role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IModuleService moduleService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model, RoleDTO roleDTO) {
		PageInfo<RoleDTO> splitPage = roleService.findSplitPage(roleDTO);
		model.addAttribute("roleSplitPages", splitPage);
		model.addAttribute("roleDto", roleDTO);
		return "admin/role/main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, RoleDTO roleDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		roleService.insertRole(roleDTO);
		map.put("success", true);
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> list(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roles", roleService.findRoleList(null));
		map.put("success", true);
		return map;
	}

	@RequestMapping(value = "/grant/{roleId}", method = RequestMethod.GET)
	public String allot(HttpServletResponse response, Model model, @PathVariable("roleId") Integer roleId) {
		List<ModuleDTO> modules = moduleService.findModuleRoleResource(roleId);
		model.addAttribute("roleId", roleId);
		model.addAttribute("modules", modules);
		return "admin/role/grant";
	}

	@RequestMapping(value = "/grant", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> grant(HttpServletResponse response, Integer[] resourceId,Integer roleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(roleId!=null) {
			roleService.grant(resourceId, roleId);
		}
		map.put("success", true);
		return map;
	}
}