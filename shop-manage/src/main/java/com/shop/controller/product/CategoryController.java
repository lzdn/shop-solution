package com.shop.controller.product;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.shop.service.product.ICategoryService;
import com.shop.dto.product.CategoryDTO;
import com.shop.domain.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 商品分类表控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
@RequestMapping(value = "category")
public class CategoryController extends BaseController {

    @Autowired
    private ICategoryService categoryService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,CategoryDTO categoryDTO) {
		PageInfo<Category> splitPage = categoryService.findSplitPage(categoryDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("categoryDTO", categoryDTO);
		return "admin/category/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, CategoryDTO categoryDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		categoryService.insertCategory(categoryDTO);
		map.put("success",true);
		return map;
	}

}