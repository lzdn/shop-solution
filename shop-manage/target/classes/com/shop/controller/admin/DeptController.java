package com.shop.controller.admin;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.shop.service.admin.IDeptService;
import com.shop.dto.admin.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 部门控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
@RequestMapping(value = "dept")
public class DeptController extends BaseController {

    @Autowired
    private IDeptService deptService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,DeptDTO deptDTO) {
		PageInfo<DeptDTO> splitPage = deptService.findSplitPage(deptDTO);
		model.addAttribute("depts", deptService.findDeptList(deptDTO));
		model.addAttribute("deptSplitPages", splitPage);
		model.addAttribute("deptDto", deptDTO);
		return "admin/dept/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, DeptDTO deptDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		deptService.insertDept(deptDTO);
		map.put("success",true);
		return map;
	}

}