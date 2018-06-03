package com.shop.security;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.shop.dto.admin.ModuleDTO;
import com.shop.dto.admin.ResourceDTO;
import com.shop.dto.admin.RoleDTO;
import com.shop.dto.admin.UserDTO;
import com.shop.service.admin.IModuleService;
import com.shop.service.admin.IRoleService;
import com.shop.service.admin.IUserService;


@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IModuleService moduleService;

	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		// SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
		// 本例使用SysUser中的name作为用户名:
		UserDTO userDTO = userService.findByAccount(account);
		if (userDTO == null) {
			throw new UsernameNotFoundException("帐户： " + account + " 不存在");
		}
		List<RoleDTO> roles = roleService.findRoleResource(userDTO.getUserId());
		if (!CollectionUtils.isEmpty(roles)) {
			RoleDTO role = roles.get(0);
			List<ModuleDTO> modules = moduleService.findModuleRoleResource(role.getRoleId());
			for (ModuleDTO module : modules) {
				List<ResourceDTO> resources = module.getResources();
				if (!CollectionUtils.isEmpty(resources)) {
					check(resources);
				}
			}
			userDTO.setModules(modules);
			userDTO.setRole(role);
		}
		SecurityUser seu = new SecurityUser(userDTO);
		return seu;
	}

	public void check(List<ResourceDTO> resources) {
		Iterator<ResourceDTO> it = resources.iterator();
		while (it.hasNext()) {
			ResourceDTO resource = it.next();
			if (resource == null)
				continue;
			if (resource.getType() != 1) {
				it.remove();
				continue;
			}
			if (resource.getIsCheck() == null) {
				it.remove();
			}
			if (!CollectionUtils.isEmpty(resource.getChildren())) {
				check(resource.getChildren());
			}
		}
	}
}
