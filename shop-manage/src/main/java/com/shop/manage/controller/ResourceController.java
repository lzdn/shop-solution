package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IResourceService;
import com.shop.manage.domain.Resource;
import com.shop.manage.dto.ResourceDTO;
import java.util.Map;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 系统资源控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
public class ResourceController extends BaseController {

    @Autowired
    private IResourceService resourceService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,ResourceDTO resourceDTO) {
		PageInfo<ResourceDTO> splitPage = resourceService.findSplitPage(resourceDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("resourceDTO", resourceDTO);
		return "admin/resource/main";
	}
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, ResourceDTO resourceDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		resourceService.insertResource(resourceDTO);
		map.put("success",true);
		return map;
	}

}