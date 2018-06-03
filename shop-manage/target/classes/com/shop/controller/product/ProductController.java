package com.shop.controller.product;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.shop.service.product.IProductService;
import com.shop.dto.product.ProductDTO;
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
@RequestMapping(value = "product")
public class ProductController extends BaseController {

    @Autowired
    private IProductService productService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,ProductDTO productDTO) {
		PageInfo<ProductDTO> splitPage = productService.findSplitPage(productDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("productDTO", productDTO);
		return "admin/product/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, ProductDTO productDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		productService.insertProduct(productDTO);
		map.put("success",true);
		return map;
	}

}