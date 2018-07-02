package com.xiangqin.action;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiangqin.action.base.BaseController;
import com.xiangqin.domain.dto.WeiXinDto;
import com.xiangqin.service.WeiXinService;

@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private WeiXinService weiXinService;

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) throws Exception {
		WeiXinDto dto = weiXinService.getSignature();
		model.addAttribute("weiXinDto", dto);
		return "/app/index";
	}

}
