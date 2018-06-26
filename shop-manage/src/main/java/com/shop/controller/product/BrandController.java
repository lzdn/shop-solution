package com.shop.controller.product;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.shop.service.product.IBrandService;
import com.shop.dto.product.BrandDTO;
import com.shop.domain.product.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 品牌表控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
@RequestMapping(value = "brand")
public class BrandController extends BaseController {

    @Autowired
    private IBrandService brandService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,BrandDTO brandDTO) {
		PageInfo<Brand> splitPage = brandService.findSplitPage(brandDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("brandDTO", brandDTO);
		return "admin/brand/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, BrandDTO brandDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		brandService.insertBrand(brandDTO);
		map.put("success",true);
		return map;
	}

}