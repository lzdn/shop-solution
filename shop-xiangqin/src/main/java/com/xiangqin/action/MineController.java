package com.xiangqin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiangqin.action.base.BaseController;
import com.xiangqin.domain.Account;
import com.xiangqin.domain.Concern;
import com.xiangqin.domain.Letter;
import com.xiangqin.service.AccountService;
import com.xiangqin.service.ConcernService;
import com.xiangqin.service.LetterService;

@Controller
@RequestMapping("mine")
public class MineController extends BaseController  {

	@Autowired
	private LetterService letterService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ConcernService concernService;
	
	@RequestMapping(value = "/mletter/{fromId}", method = RequestMethod.GET)
	public String mletter(HttpServletRequest request, @PathVariable("fromId") Integer fromId, Model model)
			throws Exception {
		Account fromAccount = accountService.findById(fromId);
		List<Letter> list = letterService.mList(fromId);
		if(!CollectionUtils.isEmpty(list)) {
			for (Letter letter : list) {
				letter.setFromAccount(fromAccount);
				letter.setToAccount(accountService.findById(letter.getToId()));
			}
		}
		model.addAttribute("letters", list);
		return "/app/mletter";
	}
	
	@RequestMapping(value = "/sletter/{toId}", method = RequestMethod.GET)
	public String sletter(HttpServletRequest request, @PathVariable("toId") Integer toId, Model model)
			throws Exception {
		Account toAccount = accountService.findById(toId);
		List<Letter> list = letterService.sList(toId);
		if(!CollectionUtils.isEmpty(list)) {
			for (Letter letter : list) {
				letter.setToAccount(toAccount);
				letter.setFromAccount(accountService.findById(letter.getToId()));
			}
		}
		model.addAttribute("letters", list);
		return "/app/sletter";
	}
	
	@RequestMapping(value = "/focus/{id}", method = RequestMethod.GET)
	public String focus(HttpServletRequest request, @PathVariable("id") Integer id, Model model)
			throws Exception {
		List<Concern> list = concernService.findByOwnerId(id);
	/*	Account toAccount = accountService.findById(toId);
		List<Letter> list = letterService.sList(toId);
		if(!CollectionUtils.isEmpty(list)) {
			for (Letter letter : list) {
				letter.setToAccount(toAccount);
				letter.setFromAccount(accountService.findById(letter.getToId()));
			}
		}
		model.addAttribute("letters", list);*/
		return "/app/sletter";
	}
}
