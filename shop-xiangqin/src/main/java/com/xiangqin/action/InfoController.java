package com.xiangqin.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiangqin.action.base.BaseController;
import com.xiangqin.domain.Person;
import com.xiangqin.service.PersonService;
import com.xiangqin.utils.Body;
import com.xiangqin.utils.DateUtil;
import com.xiangqin.utils.Result;

@Controller
@RequestMapping("info")
public class InfoController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public String find(HttpServletRequest request, @PathVariable("id") Integer id, Model model) throws Exception {
		Person person = personService.findPerson(id);
		person.setSexName(person.getSex()==1?"男":"女");
		person.setAddress(person.getProvinceName()+" "+person.getCityName()+" "+person.getCountyName());
		model.addAttribute("person", person);
		return "/app/info";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void save(HttpServletResponse response, Person person) throws IOException {
		logger.error(person.toString());
		Result result = null;
		try {
			if (person.getId() == null)
				person.setCreateTime(new Date());
			person.setUpdateTime(new Date());
			int age = DateUtil.yearDateDiff(person.getBirthday());
			person.setAge(age);
			Integer id = personService.addPerson(person);
			result = new Result(1, "保存成功!");
			Body body = new Body();
			body.setId(id);
			result.setBody(body);
		} catch (Exception e) {
			result = new Result(0, "保存失败!");
			logger.error("保存个人信息：" + e);
		}
		writeJSON(response, result);
	}

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("查询列表");
		Map<String, Object> map = new HashMap<>();
		List<Person> list = personService.list();
		map.put("success", true);
		map.put("list", list);
		return map;
	}

}
