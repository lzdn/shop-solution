package com.shop.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.shop.annotation.Verification;
import com.shop.domain.admin.Module;
import com.shop.domain.admin.Resource;
import com.shop.dto.admin.ResourceDTO;
import com.shop.service.admin.IModuleService;
import com.shop.service.admin.IResourceService;
import com.shop.web.BaseController;
import com.shop.web.Result;
import com.shop.web.ZtreeNode;

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
	
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public String tree(HttpServletResponse response, Model model, Integer id , Integer currentId) {
		
		List<String> tree = new ArrayList<String>();
		List<ZtreeNode> list = resourceService.getZtreeNode();
		for (ZtreeNode ztreeNode : list) {
			if(currentId!=null&&ztreeNode.getId()!=currentId.intValue()){
				tree.add(JSON.toJSONString(ztreeNode));
			}
		}
		model.addAttribute("resourceTree", tree);
		model.addAttribute("checkId", id);
		return "admin/resource/tree";
	}

	@Verification
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Result save(HttpServletRequest request, ResourceDTO resourceDTO) throws Exception {

		if (resourceDTO.getId() != null) {
			resourceService.updateResource(resourceDTO);
		} else {
			if (resourceDTO.getModuleId() == null) {
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
		if (dto == null) {
			model.addAttribute("message", "不存在：[" + id + "]");
			return "admin/common/notice";
		}
		ResourceDTO target = new ResourceDTO();
		BeanUtils.copyProperties(dto,target);
		List<Module> modules = moduleService.findAll(null);
		model.addAttribute("modules", modules);
		//
		if(target.getParentId()!=null&&target.getParentId().intValue()==0){
			target.setParentName("无");
		}else {
			Resource parent = resourceService.findByPk(target.getParentId());
			if(parent!=null) target.setParentName(parent.getResourceValue());
		}
		model.addAttribute("resource", target);
		return "admin/resource/edit";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result delete(HttpServletRequest request, Integer id) throws Exception {
		resourceService.deleteByPk(id);
		return new Result(SUCCESS);
	}

}