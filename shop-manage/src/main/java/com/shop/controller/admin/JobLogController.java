package com.shop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.JobLog;
import com.shop.dto.admin.JobLogDTO;
import com.shop.service.admin.IJobLogService;
import com.shop.web.BaseController;
import com.shop.web.Result;

/**
 * @date 20180602
 * @author 张林
 * @description 定时任务日志控制层
 * @gitHub:https://github.com/lzdn
 */
@Controller
@RequestMapping(value = "jobLog")
public class JobLogController extends BaseController {

	@Autowired
	private IJobLogService jobLogService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model, JobLogDTO jobLogDTO) {
		PageInfo<JobLog> splitPage = jobLogService.findSplitPage(jobLogDTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("jobLogDTO", jobLogDTO);
		return "admin/jobLog/main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(HttpServletRequest request, JobLogDTO jobLogDTO) throws Exception {
		jobLogService.insertJobLog(jobLogDTO);
		return new Result(SUCCESS);
	}

}