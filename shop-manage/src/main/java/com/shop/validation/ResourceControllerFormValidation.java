package com.shop.validation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.domain.admin.Resource;
import com.shop.dto.admin.ResourceDTO;
import com.shop.service.admin.IResourceService;
import com.shop.web.Result;

@Component
public class ResourceControllerFormValidation {

	@Autowired
	private IResourceService resourceService;

	public Result save(HttpServletRequest request, ResourceDTO resourceDTO) {

		if (resourceDTO.getParentId() == null) {
			return new Result(false);
		}
		if (resourceDTO.getParentId().intValue() == 0) {
			if (resourceDTO.getType().intValue() == 2)
				return new Result(false, "资源类型必须为菜单");
			if (resourceDTO.getLevel().intValue() != 1)
				return new Result(false, "资源级别必须为一级菜单");
		} else {
			Resource resource = resourceService.findByPk(resourceDTO.getParentId());
			switch (resource.getLevel().intValue()) {
			case 0:
				if (resourceDTO.getType().intValue() == 2)
					return new Result(false, "资源类型必须为菜单");
				if (resourceDTO.getLevel().intValue() != 1)
					return new Result(false, "资源级别必须为一级菜单");
				break;
			case 1:
				if (resourceDTO.getType().intValue() == 2)
					return new Result(false, "资源类型必须为菜单");
				if (resourceDTO.getLevel().intValue() != 2)
					return new Result(false, "资源级别必须为二级菜单");
				break;
			case 2:
				if (resourceDTO.getLevel().intValue() <= 2)
					return new Result(false, "资源级别必须为三级菜单或四级功能");
				break;
			case 3:
				if (resourceDTO.getType().intValue() == 1)
					return new Result(false, "资源类型必须为功能");
				if (resourceDTO.getLevel().intValue() != 4)
					return new Result(false, "资源级别必须为四级功能");
				break;
			}
		}
		return null;

	}
}
