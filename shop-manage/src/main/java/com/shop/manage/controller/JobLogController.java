package com.shop.manage.controller;
import com.shop.manage.web.BaseController;
import com.shop.manage.service.IJobLogService;
import com.shop.manage.domain.JobLog;
import com.shop.manage.dto.JobLogDTO;
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
* @description 定时任务日志控制层
* @gitHub:https://github.com/lzdn
*/
@Controller
public class JobLogController extends BaseController {

    @Autowired
    private IJobLogService jobLogService;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,JobLogDTO jobLogDTO) {
		PageInfo<JobLogDTO> splitPage = jobLogService.findSplitPage(jobLogDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("jobLogDTO", jobLogDTO);
		return "admin/jobLog/main";
	}
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, JobLogDTO jobLogDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		jobLogService.insertJobLog(jobLogDTO);
		map.put("success",true);
		return map;
	}

}