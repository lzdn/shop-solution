package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IUserService;
import com.shop.manage.domain.User;
import com.shop.manage.dto.UserDTO;
import java.util.Map;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date 20180602
* @author 张林
* @description 用户控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,UserDTO userDTO) {
		PageInfo<UserDTO> splitPage = userService.findSplitPage(userDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("userDTO", userDTO);
		return "admin/user/main";
	}
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, UserDTO userDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		userService.insertUser(userDTO);
		map.put("success",true);
		return map;
	}

}