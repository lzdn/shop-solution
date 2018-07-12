package com.shop.dto.admin;

import com.shop.domain.admin.Resource;

/**
 * @date 20180602
 * @author 张林
 * @description 系统资源
 * @gitHub:https://github.com/lzdn
 */
public class ResourceDTO extends Resource {

	private static final long serialVersionUID = 1L;

	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}