package com.shop.controller.admin;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;

import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import com.shop.service.admin.IRoleService;
import com.shop.service.admin.IUserService;
import com.shop.utils.MD5Util;
import com.shop.dto.admin.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 20180602
 * @author 张林
 * @description 用户控制层
 * @gitHub:https://github.com/lzdn
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model, UserDTO userDTO) {
		PageInfo<UserDTO> splitPage = userService.findSplitPage(userDTO);
		model.addAttribute("userSplitPages", splitPage);
		model.addAttribute("userDto", userDTO);
		return "admin/user/main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, UserDTO userDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		UserDTO account = userService.findByAccount(userDTO.getAccount());
		if (account != null) {
			map.put("success", false);
			return map;
		}
		userDTO.setSalt(MD5Util.SALT);
		userDTO.setPassword(MD5Util.encode(userDTO.getPassword()));
		userService.insertUser(userDTO);
		map.put("success", true);
		return map;
	}

	@RequestMapping(value = "/grant/{userId}", method = RequestMethod.GET)
	public String allot(HttpServletResponse response, Model model, @PathVariable("userId") Integer userId) {
		UserDTO user = userService.selectUserRoleByPk(userId);
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.findRoleList(null));
		return "admin/user/grant";
	}

	@RequestMapping("/addRole")
	public @ResponseBody Map<String, Object> addRole(HttpServletRequest httpRequest, Integer userId, Integer roleId)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		userService.addUserRole(userId, roleId);
		map.put("success", true);
		return map;
	}
}