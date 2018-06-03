package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IDictService;
import com.shop.manage.domain.Dict;
import com.shop.manage.dto.DictDTO;
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
* @description 系统字典控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
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
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, DictDTO dictDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		dictService.insertDict(dictDTO);
		map.put("success",true);
		return map;
	}

}