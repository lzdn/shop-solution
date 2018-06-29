package com.shop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Role;
import com.shop.domain.admin.User;
import com.shop.dto.admin.UserDTO;
import com.shop.service.admin.IRoleService;
import com.shop.service.admin.IUserService;
import com.shop.utils.MD5Util;
import com.shop.web.BaseController;
import com.shop.web.Result;

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
		PageInfo<User> splitPage = userService.findSplitPage(userDTO);
		model.addAttribute("userSplitPages", splitPage);
		model.addAttribute("userDto", userDTO);
		return "admin/user/main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(HttpServletRequest request, UserDTO userDTO) throws Exception {
		User account = userService.findByAccount(userDTO.getAccount());
		if (account != null) {
			return new Result("已经存在账户：" + userDTO.getAccount(), FAIL);
		}
		userDTO.setSalt(MD5Util.SALT);
		userDTO.setPassword(MD5Util.encode(userDTO.getPassword()));
		userService.insertUser(userDTO);
		return new Result(SUCCESS);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody Result delete(HttpServletRequest request, @PathVariable("id") Integer id) throws Exception {
		Role role = roleService.findRoleOneByUserId(id);
		if(role!=null&&role.getRoleId().intValue()==1) {
			return new Result("无法删除超级管理员", FAIL);
		}
		userService.deleteByPk(id);
		return new Result(SUCCESS);
	}
	
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String edit(HttpServletResponse response, Model model, @PathVariable("userId") Integer userId) {
		User user = userService.selectUserRoleByPk(userId);
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.findAll(null));
		return "admin/user/edit";
	}

	@RequestMapping(value = "/grant/{userId}", method = RequestMethod.GET)
	public String allot(HttpServletResponse response, Model model, @PathVariable("userId") Integer userId) {
		User user = userService.selectUserRoleByPk(userId);
		model.addAttribute("user", user);
		model.addAttribute("roles", roleService.findAll(null));
		return "admin/user/grant";
	}

	@RequestMapping("/addRole")
	public @ResponseBody Result addRole(HttpServletRequest httpRequest, Integer userId, Integer roleId)
			throws Exception {
		userService.addUserRole(userId, roleId);
		return new Result(SUCCESS);
	}
}