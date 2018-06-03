package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IDeptService;
import com.shop.manage.domain.Dept;
import com.shop.manage.dto.DeptDTO;
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
* @description 部门控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
public class DeptController extends BaseController {

    @Autowired
    private IDeptService deptService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,DeptDTO deptDTO) {
		PageInfo<DeptDTO> splitPage = deptService.findSplitPage(deptDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("deptDTO", deptDTO);
		return "admin/dept/main";
	}
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, DeptDTO deptDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		deptService.insertDept(deptDTO);
		map.put("success",true);
		return map;
	}

}