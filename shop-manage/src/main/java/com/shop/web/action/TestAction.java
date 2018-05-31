package com.shop.web.action;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dao.manage.TestMapper;
import com.shop.dao.product.Test2Mapper;
import com.shop.domain.manage.Test;
import com.shop.domain.product.Test2;
import com.shop.service.ITest;

@Controller
public class TestAction {

	@Autowired
	private ITest test;
	
	@RequestMapping(value = "/test.html", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model) {
		Test record = new Test();
		record.setName("a");
		test.addTest(record);
		Test2 record2 = new Test2();
		record2.setName("b");
		test.addTest2(record2);
		return "welcome";
	}
	
/*	@RequestMapping(value = "/select.html", method = RequestMethod.GET)
	public @ResponseBody String select(HttpServletResponse response, Model model) {
		Test record  = testMapper.selectByPrimaryKey(1);
		test2Mapper.selectByPrimaryKey(1);
		return record.toString();
	}*/
}
