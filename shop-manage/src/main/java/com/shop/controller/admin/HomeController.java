package com.shop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.security.SecurityUser;
import com.shop.web.BaseController;

@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request, Model model) throws Exception {
		return "/register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) throws Exception {
		return "/login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return "/welcome";
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		SecurityUser user = super.getLoginUser();
		if (user.getUserId() == null) {
			super.redirect(response, request.getContextPath() + "/login");
			return null;
		}
		logger.info("进入HOME");
		return "/homeV2";
	}

}
