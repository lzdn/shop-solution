package com.shop.dto.admin;

import java.util.List;

import com.shop.domain.admin.Module;
import com.shop.domain.admin.Resource;
import com.shop.domain.admin.Role;

/**
* @date 20180602
* @author 张林
* @description 角色
* @gitHub:https://github.com/lzdn
*/
public class RoleDTO extends Role{

	private static final long serialVersionUID = 1L;
	
	private List<Module> modules;

	private List<Resource> resources;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}