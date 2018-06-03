package com.shop.dto.admin;

import java.util.List;

import com.shop.domain.admin.User;

/**
 * @date 20180602
 * @author 张林
 * @description 用户
 * @gitHub:https://github.com/lzdn
 */
public class UserDTO extends User {

	private static final long serialVersionUID = 1L;

	private RoleDTO role;

	private List<ModuleDTO> modules;

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public List<ModuleDTO> getModules() {
		return modules;
	}

	public void setModules(List<ModuleDTO> modules) {
		this.modules = modules;
	}

}