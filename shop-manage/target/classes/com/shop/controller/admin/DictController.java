package com.shop.controller.admin;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.shop.service.admin.IDictService;
import com.shop.dto.admin.DictDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 系统字典控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
@RequestMapping(value = "dict")
public class DictController extends BaseController {

    @Autowired
    private IDictService dictService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,DictDTO dictDTO) {
		PageInfo<DictDTO> splitPage = dictService.findSplitPage(dictDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("dictDTO", dictDTO);
		return "admin/dict/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, DictDTO dictDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		dictService.insertDict(dictDTO);
		map.put("success",true);
		return map;
	}

}