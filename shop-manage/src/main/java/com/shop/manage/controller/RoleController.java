package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IRoleService;
import com.shop.manage.domain.Role;
import com.shop.manage.dto.RoleDTO;
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
* @description 角色控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,RoleDTO roleDTO) {
		PageInfo<RoleDTO> splitPage = roleService.findSplitPage(roleDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("roleDTO", roleDTO);
		return "admin/role/main";
	}
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, RoleDTO roleDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		roleService.insertRole(roleDTO);
		map.put("success",true);
		return map;
	}

}