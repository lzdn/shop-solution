package com.shop.dto.admin;

import java.util.List;

import com.shop.domain.admin.Resource;

/**
* @date 20180602
* @author 张林
* @description 系统资源
* @gitHub:https://github.com/lzdn
*/
public class ResourceDTO extends Resource{

	private static final long serialVersionUID = 1L;
	

	private Integer isCheck;
	
	private List<ResourceDTO> children;

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}

	public List<ResourceDTO> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceDTO> children) {
		this.children = children;
	}
}