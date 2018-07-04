package com.shop.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Module;
import com.shop.domain.admin.Resource;
import com.shop.dto.admin.ResourceDTO;
import com.shop.service.admin.IModuleService;
import com.shop.service.admin.IResourceService;
import com.shop.utils.IntegerUtil;
import com.shop.web.BaseController;
import com.shop.web.Result;

/**
 * @date 20180602
 * @author 张林
 * @description 系统资源控制层
 * @gitHub:https://github.com/lzdn
 */
@Controller
@RequestMapping(value = "resource")
public class ResourceController extends BaseController {

	@Autowired
	private IModuleService moduleService;

	@Autowired
	private IResourceService resourceService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletResponse response, Model model, ResourceDTO resourceDTO) {
		PageInfo<Resource> splitPage = resourceService.findSplitPage(resourceDTO);
		model.addAttribute("resourceSplitPages", splitPage);
		model.addAttribute("resourceDto", resourceDTO);
		model.addAttribute("resources", resourceService.findAll(null));
		String levelName = "一级菜单";
		if(IntegerUtil.isNotNullAndNotZero(resourceDTO.getParentId())) {
			Resource parentResource = resourceService.findByPk(resourceDTO.getParentId());
			model.addAttribute("parentResource", parentResource);
			switch(parentResource.getLevel().intValue()) {
			case 1:
				levelName ="一级菜单";
			case 2:
				levelName ="二级菜单";
			case 3:
				levelName ="三级菜单";
			}
		}
		model.addAttribute("levelName", levelName);
		
		return "admin/resource/list";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model, ResourceDTO resourceDTO) {
		PageInfo<Resource> splitPage = resourceService.findSplitPage(resourceDTO);
		model.addAttribute("resourceSplitPages", splitPage);
		model.addAttribute("resourceDto", resourceDTO);
		model.addAttribute("resources", resourceService.findAll(null));
		List<Module> modules = moduleService.findAll(null);
		model.addAttribute("modules", modules);
		return "admin/resource/main";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Result add(HttpServletRequest request, ResourceDTO resourceDTO) throws Exception {
		
		//校验
		if(resourceDTO.getParentId()==null) {
			return new Result(FAIL);
		}
		switch(resourceDTO.getParentId().intValue()) {
		case 0:
			if(resourceDTO.getType().intValue()==2) {
				return new Result(FAIL,"资源类型必须为菜单");
			}
			if(resourceDTO.getLevel().intValue()!=1) {
				return new Result(FAIL,"资源级别必须为一级菜单");
			}
			break;
		case 1:
			if(resourceDTO.getType().intValue()==2) {
				return new Result(FAIL,"资源类型必须为菜单");
			}
			if(resourceDTO.getLevel().intValue()!=2) {
				return new Result(FAIL,"资源级别必须为二级菜单");
			}
			break;
		case 2:
			if(resourceDTO.getLevel().intValue()<=2) {
				return new Result(FAIL,"资源级别必须为三级菜单或四级功能");
			}
			break;
		case 3:
			if(resourceDTO.getType().intValue()==1) {
				return new Result(FAIL,"资源类型必须为功能");
			}
			if(resourceDTO.getLevel().intValue()!=4) {
				return new Result(FAIL,"资源级别必须为四级功能");
			}
			break;
		}
		
		if(resourceDTO.getId()!=null) {
			resourceService.updateResource(resourceDTO);
		}else {
			if(resourceDTO.getModuleId()==null) {
				Resource res = resourceService.findByPk(resourceDTO.getParentId());
				resourceDTO.setModuleId(res.getModuleId());
			}
			resourceService.insertResource(resourceDTO);	
		}
		
		return new Result(SUCCESS);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletResponse response, Model model, Integer id) {
		Resource dto = resourceService.findByPk(id);
		if(dto == null) {
			model.addAttribute("message", "不存在：["+id+"]");
			return "admin/common/notice";
		}
		model.addAttribute("resources", resourceService.findAll(null));
		List<Module> modules = moduleService.findAll(null);
		model.addAttribute("modules", modules);
		model.addAttribute("resource", dto);
		return "admin/resource/edit";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result delete(HttpServletRequest request, Integer id) throws Exception {
		resourceService.deleteByPk(id);
		return new Result(SUCCESS);
	}

}