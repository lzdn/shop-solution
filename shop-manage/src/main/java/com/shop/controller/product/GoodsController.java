package com.shop.controller.product;

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.shop.service.product.IGoodsService;
import com.shop.dto.product.GoodsDTO;
import com.shop.domain.product.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 商品表控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
@RequestMapping(value = "goods")
public class GoodsController extends BaseController {

    @Autowired
    private IGoodsService goodsService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,GoodsDTO goodsDTO) {
		PageInfo<Goods> splitPage = goodsService.findSplitPage(goodsDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("goodsDTO", goodsDTO);
		return "admin/goods/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, GoodsDTO goodsDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		goodsService.insertGoods(goodsDTO);
		map.put("success",true);
		return map;
	}

}