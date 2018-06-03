package com.shop.dto.admin;

import java.util.List;

import com.shop.domain.admin.Module;

/**
 * @date 20180602
 * @author 张林
 * @description 系统模块
 * @gitHub:https://github.com/lzdn
 */
public class ModuleDTO extends Module {

	private static final long serialVersionUID = 1L;

	private List<ResourceDTO> resources;

	public List<ResourceDTO> getResources() {
		return resources;
	}

	public void setResources(List<ResourceDTO> resources) {
		this.resources = resources;
	}

}