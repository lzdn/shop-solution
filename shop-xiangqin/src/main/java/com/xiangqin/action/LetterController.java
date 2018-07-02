package com.xiangqin.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiangqin.action.base.BaseController;
import com.xiangqin.domain.Letter;
import com.xiangqin.domain.Person;
import com.xiangqin.service.LetterService;
import com.xiangqin.service.PersonService;
import com.xiangqin.utils.Result;

@Controller
@RequestMapping("letter")
public class LetterController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(LetterController.class);

	@Autowired
	private PersonService personService;

	@Autowired
	private LetterService letterService;

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @PathVariable("id") Integer id, Model model) throws Exception {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "/app/letter";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void save(HttpServletResponse response, Letter letter) throws IOException {
		logger.error(letter.toString());
		Result result = null;
		try {
			if (letter.getId() == null)
				letter.setCreateTime(new Date());
			letter.setUpdateTime(new Date());
			letterService.save(letter);
			result = new Result(1, "保存成功!");
		} catch (Exception e) {
			result = new Result(0, "保存失败!");
			logger.error("保存个人信息：" + e);
		}
		writeJSON(response, result);
	}

}
